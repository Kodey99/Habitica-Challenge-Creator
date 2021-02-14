package com.kodey.challengeCreator.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONObject;

import com.kodey.challengeCreator.model.Challenge;
import com.kodey.challengeCreator.model.Task;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kodey.challengeCreator.model.Habit;
import com.kodey.challengeCreator.model.Daily;
import com.kodey.challengeCreator.model.ToDo;
import com.kodey.challengeCreator.utilities.HTTPRequests;
import com.kodey.challengeCreator.model.Reward;

@Service
public class ChallengeService {

    private String challengeURL = "https://habitica.com/api/v3/challenges";
    private String taskURL = "https://habitica.com/api/v3/tasks/challenge/";


    public void createChallenge(Challenge challenge, String userId, String apiToken) throws ClientProtocolException, IOException {
        System.out.println("Starting creation of challenge");
        System.out.println(userId);
        System.out.println(apiToken);
        //send post to create the challenge
        JSONObject response = HTTPRequests.sendPost(challenge.toString(), challengeURL, userId, apiToken);

        String challengeID = response.getJSONObject("data").getString("id");

        System.out.println(challengeID);
        System.out.println("Challenge created");
        System.out.println("Starting creation of tasks");
        
        //sends posts to create each of the habbits
        String fullTaskURL = taskURL + challengeID;
        for (Task task : challenge.getTasks()) {
            System.out.println(task);
            HTTPRequests.sendPost(task.toString(), fullTaskURL, userId, apiToken);
        }
    }

    public Challenge readChallengeFile(MultipartFile file) {
        List<String> taskStrings = new ArrayList<>();

        Challenge challenge = new Challenge();
        try {
            BufferedReader myReader = new BufferedReader(new InputStreamReader(file.getInputStream()));
            challenge.setName(myReader.readLine());
            challenge.setShortName(myReader.readLine());
            challenge.setSummary(myReader.readLine());
            challenge.setDescription(myReader.readLine());
            challenge.setGroupID(myReader.readLine());
            challenge.setPrize(Integer.parseInt(myReader.readLine()));

            String line;
            while ((line = myReader.readLine()) != null) {
                taskStrings.add(line);
            }
            myReader.close();

            List<Task> taskList = createTasks(taskStrings);
            challenge.setTasks(taskList);

        } catch (IOException e) {
            System.out.println("An error occurred while reading the file " + file.getOriginalFilename());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("An error occurred " + file.getOriginalFilename());
            e.printStackTrace();
        }

        return challenge;
    }

    public static List<Task> createTasks(List<String> taskStrings) {

        List<Task> taskList = new ArrayList<>(taskStrings.size());
        for (String taskString : taskStrings) {
            String[] taskDetails = taskString.split(";\t");
            Task task = null;
            switch (taskDetails[0]) {
                case ("Habit"):
                    task = new Habit(taskDetails);
                    break;
                case ("Daily"):
                    task = new Daily(taskDetails);
                    break;
                case ("To-Do"):
                    task = new ToDo(taskDetails);
                    break;
                case ("Reward"):
                    task = new Reward(taskDetails);
                    break;
                case ("default"):
                    break;
            }
            if (task != null) {
                taskList.add(task);
            }
        }
        return taskList;
    }
}
