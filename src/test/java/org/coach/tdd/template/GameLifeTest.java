package org.coach.tdd.template;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class GameLifeTest {
    @Test
    public void shouldReturnTheNumberOfAliveAround() throws Exception {
        int[][] arr = {{1, 1, 1}, {1, 0, 1}, {1, 0, 0}};
        GameLife gameLife = new GameLife(arr);
        assertEquals(2, gameLife.calculateCellAroundAliveNumber(0, 0));
        assertEquals(4, gameLife.calculateCellAroundAliveNumber(0, 1));
        assertEquals(2, gameLife.calculateCellAroundAliveNumber(0, 2));
        assertEquals(3, gameLife.calculateCellAroundAliveNumber(1, 0));
    }

    @Test
    public void shouldReturnCurrentCellState() throws Exception {
        int[][] arr = {{1, 1, 1}, {1, 0, 1}, {1, 0, 0}};
        GameLife gameLife = new GameLife(arr);
        assertEquals(1, gameLife.updateCellState(0, 0));
        assertEquals(0, gameLife.updateCellState(0, 1));
        assertEquals(1, gameLife.updateCellState(0, 2));
        assertEquals(1, gameLife.updateCellState(1, 0));
    }

    @Test
    public void shouldReturnLastCellMapState() throws Exception {
        int[][] arr = {{1, 1, 1}, {1, 0, 1}, {1, 0, 0}};
        GameLife gameLife = new GameLife(arr);
        int[][] lastArr = gameLife.updateCellMap();
        int[][] exp = {{1, 0, 1}, {1, 0, 1}, {0, 1, 0}};
        assertArrayEquals(exp, lastArr);
    }
}
