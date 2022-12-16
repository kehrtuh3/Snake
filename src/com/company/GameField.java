package com.company;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameField {
    private final Player player;
    private final NewCell[][] gameField;

    private boolean isGameEnd;

    private int headX;
    private int headY;

    private final Random rnd = new Random();

//    public static final int DEFAULT_SNAKE_LENGTH = 3;
//    public static final int DEFAULT_FIELD_SIZE = 10;
//
//    public static final MovementVector DEFAULT_DIRECTION = MovementVector.RIGHT;

//    public Game(Player player, Settings gameSettings) {
//        this.player = player;
//        this.gameField = initField(gameSettings.getFieldSize(), gameSettings.getSnakeLength());
//        this.isGameEnd = false;
//    }


    public GameField(Player player) {
        this.player = player;
        this.player.setState(PlayerCondition.PLAY);
        gameField = initField(Settings.DEFAULT_FIELD_SIZE, Settings.DEFAULT_SNAKE_LENGTH);
        addAppleToField();

        //direction = Settings.DEFAULT_DIRECTION;
    }

    private void addAppleToField() {
        List<Point> freePoints = new ArrayList<>();
        for (int row = 0; row < gameField.length; row++) {
            for (int col = 0; col < gameField[row].length; col++) {
                if (gameField[row][col].getCellState() == Cell.FREE) {
                    freePoints.add(new Point(col, row));
                }
            }
        }

        if (freePoints.size() == 0) {
            player.setState(PlayerCondition.WIN);

            //обработка победы
        }

        Point applePoint = freePoints.get(rnd.nextInt(freePoints.size()));
        gameField[applePoint.y][applePoint.x] = new NewCell(Cell.APPLE);
    }

    private NewCell[][] initField(int fieldSize, int length) {
        headX = fieldSize / 2;
        headY = fieldSize / 2;

        NewCell[][] field = new NewCell[fieldSize][fieldSize];
        for (int r = 0; r < field.length; r++) {
            for (int c = 0; c < field[r].length; c++) {
                if (r == 0 || r == fieldSize - 1  || c == 0 || c == fieldSize - 1) {
                    field[r][c] = new NewCell(Cell.WALL);
                } else {
                    field[r][c] = new NewCell(Cell.FREE);
                }
            }
        }

        initSnake(field, length);

        return field;
    }

    private void printField(NewCell[][] field) {
        for (NewCell[] cells : field) {
            for (NewCell cell : cells) {
                System.out.print(cell.getCellState() + " ");
            }
            System.out.println();
        }
    }

    private void initSnake(NewCell[][] field, int snakeLength) {
        int curColIndex = headY;
        for (int curLenght = snakeLength; curLenght >= 1; curLenght--) {
            field[headY][curColIndex] = new NewCell(Cell.SNAKE, curLenght);
            curColIndex--;
        }
    }



    public void move() {
        int newHeadX = headX, newHeadY = headY;

        switch (player.direction) {
            case RIGHT:
                newHeadX++;
                break;
            case BOT:
                newHeadY--;
                break;
            case TOP:
                newHeadY++;
                break;
            case LEFT:
                newHeadX--;
                break;
        }

        NewCell newHeadCell = gameField[newHeadY][newHeadX];
        if (newHeadCell.getCellState() == Cell.SNAKE || newHeadCell.getCellState() == Cell.WALL) {
            player.setState(PlayerCondition.LOSE);
            //обработка поражения
        }

        if (newHeadCell.getCellState() == Cell.APPLE) {
            player.addLength();
            gameField[newHeadY][newHeadX] = new NewCell(Cell.SNAKE, player.getLength());
            addAppleToField();
        } else {
            for (NewCell[] cells : gameField) {
                for (NewCell cell : cells) {
                    if (cell.getCellState() == Cell.SNAKE) {
                        cell.minimize();

                    }
                }
            }
        }
        headX = newHeadX;
        headY = newHeadY;
    }
}


