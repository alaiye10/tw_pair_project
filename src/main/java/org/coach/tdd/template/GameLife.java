package org.coach.tdd.template;

public class GameLife {

    public static final int ALIVE_COUNT = 3;
    public static final int KEEP_COUNT = 2;
    public static final int ALIVE_STATE = 1;
    public static final int DEATH_STATE = 0;

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
        if (cellAroundAliveNumber == ALIVE_COUNT) {
            result = ALIVE_STATE;
        } else if (cellAroundAliveNumber == KEEP_COUNT) {
            result = cellMap[x][y];
        } else {
            result = DEATH_STATE;
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
