package com.kodey.challengeCreator.model;

public class Habit extends Task {

    private Difficulty priority;
    private Boolean up = false;
    private Boolean down = false;

    public Habit(String[] taskDetails) {
        super("habit", taskDetails[1].trim(), taskDetails[2].trim());
        this.setPriority(taskDetails[3].trim());
        setUpDown(taskDetails[4].trim());
    }

    public String getPriority() {
        return priority.name();
    }

    public void setPriority(String priority) {
        this.priority = Difficulty.valueOf(priority.toUpperCase().trim());
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
        sb.append("&up=" + up);
        sb.append("&down=" + down);
        return sb.toString();
    }
}

