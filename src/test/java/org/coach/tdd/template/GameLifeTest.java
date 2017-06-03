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
        assertEquals(0,gameLife.getAliveNumber(1,1));
    }
}
