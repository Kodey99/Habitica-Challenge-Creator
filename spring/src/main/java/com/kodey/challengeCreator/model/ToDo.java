package com.kodey.challengeCreator.model;

public class ToDo extends Task {

    private Difficulty priority;
    private String dueDate;

    public ToDo(String[] taskDetails) {
        super("todo", taskDetails[1].trim(), taskDetails[2].trim());
        this.setPriority(taskDetails[3].trim());
        this.setDueDate(taskDetails[4].trim());
    }

    public String getPriority() {
        return priority.name();
    }

    public void setPriority(String priority) {
        this.priority = Difficulty.valueOf(priority.toUpperCase().trim());
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("&priority=" + priority.getDifficulty());
        sb.append("&date=" + dueDate);
        return sb.toString();
    }
}

