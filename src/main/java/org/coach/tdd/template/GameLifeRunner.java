package org.coach.tdd.template;


import javax.swing.*;
import java.awt.*;

/**
 * Created by XvWenJun on 2017/6/3.
 */
public class GameLifeRunner {

    private static JLabel[][] labels = new JLabel[10][10];
    private static JFrame frame;

    private static void createAndShowGUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        frame = new JFrame("HelloWorldSwing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(200, 200);
        frame.setLayout(new GridLayout(10, 10));


        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                JLabel label = new JLabel();
                label.setText(String.valueOf(i));
                frame.getContentPane().add(label);
                labels[i][j] = label;
            }
        }

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        int row = 10;
        int col = 10;

        int[][] initCellMap = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                initCellMap[i][j] = (int)(Math.random() * 2);
            }
        }

        GameLife gameLife = new GameLife(initCellMap);

        createAndShowGUI();
        for (int i = 0; i < 50; i++) {
            int[][] arr=gameLife.updateCellMap();

            configLabels(arr);
            printArr(arr);
        }

    }

    private static void printArr(int[][] arr) {
        for (int j = 0; j <10 ; j++) {
            for (int k = 0;k < 10; k++)
                System.out.print(arr[j][k]+"\t");
            System.out.println();
        }
        System.out.println("-----------");
    }

    private static void configLabels(int[][] array) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                labels[i][j].setText(String.valueOf(array[i][j]));
            }
        }

        frame.repaint();

    }

    private static String descCellMap(int[][] array) {
        int row = array.length;
        int col = array[0].length;

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                stringBuilder.append(array[i][j] + " ");
            }
            stringBuilder.append("\r\n");
        }

        return stringBuilder.toString();
    }
}
