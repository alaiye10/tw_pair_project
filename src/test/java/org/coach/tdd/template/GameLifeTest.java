package org.coach.tdd.template;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class GameLifeTest {
    @Test
    public void shouldReturnTheNumberOfAliveAround() throws Exception {
        int arr[][] = {{1, 1, 1}, {1, 0, 1},{1, 0,0}};
        GameLife gameLife = new GameLife(arr);
        assertEquals(2,gameLife.getAliveNumber(0,0));
        assertEquals(4,gameLife.getAliveNumber(0,1));
        assertEquals(2,gameLife.getAliveNumber(0,2));
        assertEquals(3,gameLife.getAliveNumber(1,0));
    }

    @Test
    public void shouldReturnCurrentCellState() throws Exception {
        int arr[][] = {{1, 1, 1}, {1, 0, 1},{1, 0,0}};
        GameLife gameLife = new GameLife(arr);
        assertEquals(1, gameLife.getCellState(0, 0));
        assertEquals(0,gameLife.getCellState(0,1));
        assertEquals(1,gameLife.getCellState(0,2));
        assertEquals(1,gameLife.getCellState(1,0));
    }

    @Test
    public void shouldReturnLastCellMapState() throws Exception {
        int arr[][] = {{1, 1, 1}, {1, 0, 1},{1, 0,0}};
        GameLife gameLife = new GameLife(arr);
        int lastArr[][] = gameLife.getCellMap();
        int exp[][]={{1, 0, 1}, {1, 0, 1}, {0, 1, 0}};
        assertArrayEquals(exp,lastArr);
    }
}
