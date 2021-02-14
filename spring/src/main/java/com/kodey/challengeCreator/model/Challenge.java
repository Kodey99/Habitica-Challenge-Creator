package com.kodey.challengeCreator.model;

import java.util.List;

public class Challenge {
  private String name;
  private String groupID;
  private String shortName;
  private String summary;
  private String description;
  private Integer prize;
  private List<Task> tasks;

  public Challenge() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getPrize() {
    return prize;
  }

  public void setPrize(Integer prize) {
    this.prize = prize;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getSummary() {
    return summary;
  }

  public void setSummary(String summary) {
    this.summary = summary;
  }

  public String getShortName() {
    return shortName;
  }

  public void setShortName(String shortName) {
    this.shortName = shortName;
  }

  public String getGroupID() {
    return groupID;
  }

  public void setGroupID(String groupID) {
    this.groupID = groupID;
  }

  public List<Task> getTasks() {
    return tasks;
  }

  public void setTasks(List<Task> tasks) {
    this.tasks = tasks;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("group=" + this.getGroupID()); 
    sb.append("&name=" + this.getName());
    sb.append("&shortName=" + this.getShortName()); 
    sb.append("&summary=" + this.getSummary());
    sb.append("&description=" + this.getDescription());
    sb.append("&prize=" + this.getPrize());
    return sb.toString();
  }
}
