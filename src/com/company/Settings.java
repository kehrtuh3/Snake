package com.company;

public class Settings {
    private int snakeLength;
    private int fieldSize;

    //private MovementVector direction;

    public static final int DEFAULT_SNAKE_LENGTH = 3;
    public static final int DEFAULT_FIELD_SIZE = 10;

    public static final Vector DEFAULT_DIRECTION = Vector.RIGHT;

    public Settings(int snakeLength, int fieldSize, Vector direction) {
        this.snakeLength = snakeLength;
        this.fieldSize = fieldSize;
        //this.direction = direction;
    }

    public Settings() {
        this.snakeLength = DEFAULT_SNAKE_LENGTH;
        this.fieldSize = DEFAULT_FIELD_SIZE;
        //this.direction = DEFAULT_DIRECTION;
    }

    public int getSnakeLength() {
        return snakeLength;
    }

    public int getFieldSize() {
        return fieldSize;
    }

//    public Vector getDirection() {
//        return direction;
//    }
}

