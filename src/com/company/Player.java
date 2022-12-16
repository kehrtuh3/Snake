package com.company;

public class Player {
    private String name;

    private int length;
    private int points;

    protected Vector direction;
    protected PlayerCondition state;

    //public final static int DEFAULT_LENGTH = 3;


    public Player(String name) {
        this.name = name;
    }

    public Player(String name, int length) {
        this.name = name;
        this.length = length;
    }

    public void addLength() {
        length++;
    }

    public void addPoints() {
        points++;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Vector getDirection() {
        return direction;
    }

    public void setDirection(Vector direction) {
        this.direction = direction;
    }

    public PlayerCondition getState() {
        return state;
    }

    public void setState(PlayerCondition state) {
        this.state = state;
    }
}


