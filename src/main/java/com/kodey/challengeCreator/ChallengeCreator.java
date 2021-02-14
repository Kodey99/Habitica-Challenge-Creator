package com.kodey.challengeCreator;

import javax.annotation.Resource;

import com.kodey.challengeCreator.service.ChallengeService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChallengeCreator implements CommandLineRunner {
  @Resource
  ChallengeService challengeService;

  public static void main(String[] args) {
    SpringApplication.run(ChallengeCreator.class, args);
  }

  @Override
  public void run(String... arg) throws Exception {
  }
}
