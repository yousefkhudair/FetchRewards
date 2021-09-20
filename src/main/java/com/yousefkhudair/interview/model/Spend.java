package com.yousefkhudair.interview.model;

public class Spend {
    private Integer points;

    public Spend() {
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "Spend{" +
                "points=" + points +
                '}';
    }
}
