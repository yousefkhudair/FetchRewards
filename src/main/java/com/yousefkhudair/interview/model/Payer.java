package com.yousefkhudair.interview.model;

public class Payer {
    private String payer;
    private Integer points;

    public Payer(String payer, Integer points) {
        this.payer = payer;
        this.points = points;
    }

    public String getPayer() {
        return payer;
    }

    public void setPayer(String payer) {
        this.payer = payer;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public void addTo(int points){
        this.points = this.points+ points;
    }

    @Override
    public String toString() {
        return "Payer{" +
                "payer='" + payer +
                ", points=" + points +
                '}';
    }
}
