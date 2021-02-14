package com.kodey.challengeCreator.model;

public class Daily extends Task {

    private Difficulty priority;

    public Daily(String[] taskDetails) {
        super("daily", taskDetails[1].trim(), taskDetails[2].trim());
        this.setPriority(taskDetails[3].trim());
    }

    public String getPriority() {
        return priority.name();
    }

    public void setPriority(String priority) {
        this.priority = Difficulty.valueOf(priority.toUpperCase().trim());
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("&priority=" + priority.getDifficulty());
        return sb.toString();
    }
}

