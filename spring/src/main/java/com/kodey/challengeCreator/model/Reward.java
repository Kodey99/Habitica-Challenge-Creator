package com.kodey.challengeCreator.model;

public class Reward extends Task {

    private String cost;

    public Reward(String[] taskDetails) {
        super("reward", taskDetails[1].trim(), taskDetails[2].trim());
        this.setCost(taskDetails[3].trim());
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("&value=" + cost);
        return sb.toString();
    }
}

