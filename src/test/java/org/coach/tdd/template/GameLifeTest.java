package org.coach.tdd.template;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class GameLifeTest {

    private GameLife classUnderTest;

    @Before
    public void setUp() throws Exception {
        int status[][] = {{1, 1, 1},{1, 0, 1},{1, 1, 1}};
        classUnderTest = new GameLife(status);

    }


    @Test
    public void shouldAliveOnlyThreeAliveAround() throws Exception {
        int act = classUnderTest.checkStatus(1, 1, 1);
        int exp = 1;
        assertEquals(act, exp);
    }
}
