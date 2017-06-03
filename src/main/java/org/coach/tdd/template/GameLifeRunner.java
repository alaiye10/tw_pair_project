package org.coach.tdd.template;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;



/**
 * Created by XvWenJun on 2017/6/3.
 */
public class GameLifeRunner {

    public static final int ROW_CELL = 20;
    public static final int COL_CELL = 20;
    public static final int ROW_CELL_WIDTH = 40;
    public static final int DEPTH = 50;
    public static final int SPEED = 100;
    private static JLabel[][] labels = new JLabel[ROW_CELL][COL_CELL];
    private static JFrame frame;



    public static void main(String[] args) {

        int[][] initCellMap = new int[ROW_CELL][COL_CELL];
        for (int i = 0; i < ROW_CELL; i++) {
            for (int j = 0; j < COL_CELL; j++) {
                initCellMap[i][j] = (int) (Math.random() * 2);
            }
        }
        GameLife gameLife = new GameLife(initCellMap);

        createAndShowGUI();
        for (int i = 0; i < DEPTH; i++) {
            int[][] cellMap = gameLife.updateCellMap();
            configLabels(cellMap);
        }
    }


    private static void createAndShowGUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        frame = new JFrame("Game Life");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(ROW_CELL_WIDTH * ROW_CELL, ROW_CELL_WIDTH * COL_CELL);
        frame.setLayout(new GridLayout(ROW_CELL, COL_CELL));


        for (int i = 0; i < ROW_CELL; i++) {
            for (int j = 0; j < COL_CELL; j++) {
                JLabel label = new JLabel();
                label.setText(String.valueOf(i));
                frame.getContentPane().add(label);
                labels[i][j] = label;
            }
        }

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void configLabels(int[][] array) {
        try {
            Thread.sleep(SPEED);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < ROW_CELL; i++) {
            for (int j = 0; j < COL_CELL; j++) {
                int num = array[i][j];
                String c = num == GameLife.ALIVE_STATE ? "*" : " ";
                labels[i][j].setText(c);
            }
        }

        frame.repaint();
    }
}
