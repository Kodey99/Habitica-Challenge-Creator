package com.kodey.challengeCreator.utilities;

import javax.net.ssl.HttpsURLConnection;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONObject;

public class HTTPRequests {

    private static String client = "e85ec436-a0f5-4b73-b89f-db9772a064d6-ChallengeCreator";

    public static JSONObject sendPost(String params, String url, String userId, String apiToken) throws ClientProtocolException, IOException {

        System.out.println(params);
        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

        byte[] postData = params.getBytes(StandardCharsets.UTF_8);
        int postDataLength = postData.length;

        con.setRequestMethod("POST");
        con.setRequestProperty("x-client", client);
        con.setRequestProperty("x-api-user", userId);
        con.setRequestProperty("x-api-key", apiToken);

        // Send post request with body
        con.setDoOutput(true);
        con.setInstanceFollowRedirects(false);
        con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        con.setRequestProperty("charset", "utf-8");
        con.setRequestProperty("Content-Length", Integer.toString(postDataLength));
        con.setUseCaches(false);
        DataOutputStream outputStream = new DataOutputStream(con.getOutputStream());
        outputStream.write(postData);

        int responseCode = con.getResponseCode();
        System.out.println("Response Code : " + responseCode);
        BufferedReader in;
        if (responseCode < 300) {
            in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        } else {
            in = new BufferedReader(new InputStreamReader(con.getErrorStream()));
        }
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        outputStream.flush();
        outputStream.close();
        con.disconnect();
        System.out.println("send post method finished");
        return new JSONObject(response.toString());
    }

}
