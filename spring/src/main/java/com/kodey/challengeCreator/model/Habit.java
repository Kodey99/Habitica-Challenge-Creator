package com.kodey.challengeCreator.model;

public class Habit extends Task {

    private Difficulty priority;
    private String frequency;
    private Boolean up = false;
    private Boolean down = false;

    public Habit(String[] taskDetails) {
        super("habit", taskDetails[1].trim(), taskDetails[2].trim());
        this.setPriority(taskDetails[3].trim());
        setFrequency(taskDetails[4].trim());
        setUpDown(taskDetails[5].trim());
    }

    public String getPriority() {
        return priority.name();
    }

    public void setPriority(String priority) {
        this.priority = Difficulty.valueOf(priority.toUpperCase().trim());
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency.toLowerCase();
    }

    public Boolean getUp() {
        return up;
    }

    public void setUp(Boolean up) {
        this.up = up;
    }

    public Boolean getDown() {
        return down;
    }

    public void setDown(Boolean down) {
        this.down = down;
    }

    private void setUpDown(String options) {
        if (options.contains("+")) {
            setUp(true);
        }
        if (options.contains("-")) {
            setDown(true);
        }
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("&priority=" + priority.getDifficulty());
        sb.append("&frequency=" + getFrequency());
        sb.append("&up=" + getUp());
        sb.append("&down=" + getDown());
        return sb.toString();
    }
}

