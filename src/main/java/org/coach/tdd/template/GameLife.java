package org.coach.tdd.template;

public class GameLife {

    private int kWidth;
    private int kHeight;
    private int[][] cellMap;

    public GameLife(int[][] arr) {
        cellMap = arr;
        kHeight = cellMap.length;
        kWidth = cellMap[0].length;
    }

    public int[][] updateCellMap() {
        calculateNextCellMap();
        return cellMap;
    }

    public void calculateNextCellMap() {
        int[][] nextCellMap = new int [kHeight][kWidth];
        for (int i = 0; i < kHeight ; i++) {
            for (int j = 0; j < kWidth ; j++) {
                nextCellMap[i][j] = updateCellState(i, j);
            }
        }
        cellMap = nextCellMap;
    }

    public int updateCellState(int x, int y) {
        int cellAroundAliveNumber = calculateCellAroundAliveNumber(x, y);

        int result;
        if (cellAroundAliveNumber == 3) {
            result = 1;
        } else if (cellAroundAliveNumber == 2) {
            result = cellMap[x][y];
        } else {
            result = 0;
        }

        return result;
    }

    public int calculateCellAroundAliveNumber(int x, int y) {
        int sum = 0;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1 ; j++) {
                if (i == x && j == y) {
                    continue;
                } else {
                    sum += getCellState(i, j);
                }
            }
        }

        return sum;
    }

    private int getCellState(int x, int y) {
        if (x >= 0 && x < kWidth && y >= 0 && y < kHeight) {
            return cellMap[x][y];
        }

        return 0;
    }
}
