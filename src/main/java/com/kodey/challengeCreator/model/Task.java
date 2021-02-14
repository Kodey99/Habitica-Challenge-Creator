package com.kodey.challengeCreator.model;

public class Task {
    private String type;
    private String text;
    private String notes;

    public Task(String type, String text, String notes) {
        this.setType(type);
        this.setText(text);
        this.setNotes(notes);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("type=" + type);
        sb.append("&text=" + text);
        sb.append("&notes=" + notes);
        return sb.toString();
    }
}

enum Difficulty{
    TRIVIAL, EASY, MEDIUM, HARD;

    public String getDifficulty() {
      switch(this) {
        case TRIVIAL:
          return "0.1";
  
        case EASY:
          return "1";
  
        case MEDIUM:
          return "1.5";
  
        case HARD:
          return "2";
  
        default:
          return "1";
        }
    }

}