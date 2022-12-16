package com.company;

public class NewCell {
    private Cell cellState;

    private int lifeTime;

    public NewCell(Cell cellState, int lifeTime) {
        this.cellState = cellState;
        this.lifeTime = lifeTime;
    }

    public NewCell(Cell cellState) {
        this(cellState, 0);
    }

    public void minimize() {
        lifeTime--;

        //сделать проверку на ноль
    }

    public Cell getCellState() {
        return cellState;
    }

    public void setCellState(Cell cellState) {
        this.cellState = cellState;
    }

    public int getLifeTime() {
        return lifeTime;
    }

    public void setLifeTime(int lifeTime) {
        this.lifeTime = lifeTime;
    }
}

