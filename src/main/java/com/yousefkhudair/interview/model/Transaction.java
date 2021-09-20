package com.yousefkhudair.interview.model;
import java.time.LocalDateTime;
import java.util.Date;


public class Transaction implements Comparable<Transaction>{

    private String payer;
    private Integer points;
    private LocalDateTime timestamp;

    public Transaction(String payer, int points, LocalDateTime timestamp) {
        this.payer = payer;
        this.points = points;
        this.timestamp = timestamp;
    }

    public String getPayer() {
        return payer;
    }

    public void setPayer(String payer) {
        this.payer = payer;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }


    @Override
    public int compareTo(Transaction o) {
        return this.timestamp.compareTo(o.getTimestamp());
    }
}
