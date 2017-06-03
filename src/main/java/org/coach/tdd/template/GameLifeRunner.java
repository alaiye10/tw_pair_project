package org.coach.tdd.template;


import java.io.IOException;

/**
 * Created by XvWenJun on 2017/6/3.
 */
public class GameLifeRunner {
    public static void main(String[] args) {
        int row = 10;
        int col = 10;

        int[][] initCellMap = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                initCellMap[i][j] = (int)(Math.random() * 2);
            }
        }

        printArray(initCellMap);

        GameLife gameLife = new GameLife(initCellMap);
        for (int i = 0; i < 5; i++) {
            printArray(gameLife.updateCellMap());
        }

    }

    private static void printArray(int[][] array) {
        clearConsole();
        int row = array.length;
        int col = array[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void clearConsole() {
        try {
            Runtime.getRuntime().exec("cls");
        } catch (IOException e) {
           // e.printStackTrace();
        }
    }


}
