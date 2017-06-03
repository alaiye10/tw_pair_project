package org.coach.tdd.template;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class GameLifeRunner {

    public static final int ROW_CELL = 20;
    public static final int COL_CELL = 20;
    public static final int ROW_CELL_WIDTH = 40;
    public static final int DEPTH = 500;
    public static final String SLOW = "Slow";
    public static final String NORMAL = "Normal";
    public static final String FAST = "Fast";
    public static final int SLOW_SPEED = 200;
    public static final int NORMAL_SPEED = 100;
    public static final int FAST_SPEED = 50;
    private static int speed = 100;
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

        createFrameAndShow();
        for (int i = 0; i < DEPTH; i++) {
            int[][] cellMap = gameLife.updateCellMap();
            configLabels(cellMap);
        }
    }


    private static void createFrameAndShow() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        frame = new JFrame("Game Life");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(ROW_CELL_WIDTH * ROW_CELL, ROW_CELL_WIDTH * COL_CELL);
        frame.setLayout(new GridLayout(ROW_CELL, COL_CELL));


        for (int i = 0; i < ROW_CELL; i++) {
            for (int j = 0; j < COL_CELL; j++) {
                JLabel label = new JLabel();
                label.setOpaque(true);
                label.setText(String.valueOf(i));
                label.setBorder(BorderFactory.createLineBorder(Color.BLUE));

                frame.getContentPane().add(label);
                labels[i][j] = label;
            }
        }

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        createMenu();
    }

    private static void createMenu() {
        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        JMenu speedMenu = new JMenu("Speed");
        JMenuItem slowItem = new JMenuItem(SLOW);
        JMenuItem normalItem = new JMenuItem(NORMAL);
        JMenuItem fastItem = new JMenuItem(FAST);
        speedMenu.add(slowItem);
        speedMenu.add(normalItem);
        speedMenu.add(fastItem);
        setMenuItemAction(slowItem, SLOW_SPEED);
        setMenuItemAction(normalItem, NORMAL_SPEED);
        setMenuItemAction(fastItem, FAST_SPEED);
        menuBar.add(speedMenu);
    }

    private static void setMenuItemAction(JMenuItem item, int speedLevel) {
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                speed = speedLevel;
            }
        });
    }

    private static void configLabels(int[][] array) {
        pauseUpdateUI();

        for (int i = 0; i < ROW_CELL; i++) {
            for (int j = 0; j < COL_CELL; j++) {
                int num = array[i][j];
                labels[i][j].setText(" ");
                if (num == 1) {
                    labels[i][j].setBackground(Color.BLACK);
                } else {
                    labels[i][j].setBackground(Color.WHITE);
                }
            }
        }
    }

    private static void pauseUpdateUI() {
        try {
            Thread.sleep(speed);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
