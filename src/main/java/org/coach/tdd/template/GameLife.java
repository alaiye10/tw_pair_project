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

    private void printCellMap(int[][] map) {
        for (int i = 0; i < kHeight ; i++) {
            for (int j = 0; j < kWidth ; j++) {
                System.out.println(cellMap[i][j]);
            }
        }
    }


    public int getAliveNumber(int x, int y) {
        int sum = 0;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1 ; j++) {
                if (i == x && j == y) {
                    continue;
                } else {
                    sum += isCellAlive(i, j);
                }
            }
        }

        return sum;
    }

    private int isCellAlive(int x, int y) {
        if (x >= 0 && x < kWidth && y >= 0 && y < kHeight) {
            return cellMap[x][y];
        }

        return 0;
    }

    public int getCellState(int x, int y) {
        int cellAroundAliveNumber = getAliveNumber(x, y);

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

    public int[][] getCellMap() {
        nextCellMap();
        return cellMap;
    }

    public void nextCellMap() {
        int[][] nextArr = new int [kHeight][kWidth];
        for (int i = 0; i < kHeight ; i++) {
            for (int j = 0; j < kWidth ; j++) {
                nextArr[i][j] = getCellState(i, j);
            }
        }
        cellMap = nextArr;
    }
}
