package com.kodey.challengeCreator.controller;

import com.kodey.challengeCreator.model.Challenge;
import com.kodey.challengeCreator.service.ChallengeService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@CrossOrigin("http://localhost:8081")
public class ChallengeController {

  @Autowired
  ChallengeService challengeService;

  @PostMapping("/upload")
  public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("userId") String userId, @RequestParam("apiToken") String apiToken) {
    try {
      Challenge challenge = challengeService.readChallengeFile(file);

      challengeService.createChallenge(challenge, userId, apiToken);
      System.out.println("All tasks created!");
      return ResponseEntity.status(HttpStatus.OK).body("Challenge created");
    } catch (Exception e) {
      System.out.println("IN THE CATCH FOR SOME REASON");
      e.printStackTrace();
      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Something went wrong");
    }
  }
}
