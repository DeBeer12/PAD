package sample.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    private Game game;
    private int actual;
    private int expected;

    @Before
    public void setUp() throws Exception {
        game = new Game(1,2,5,78,19,43);
    }

    @Test
    public void getId() {
        expected = 1;
        actual = game.getId();
        assertEquals(expected,actual);
    }

    @Test
    public void getSensor1() {
        expected = 2;
        actual = game.getSensor1();
        assertEquals(expected,actual);
    }

    @Test
    public void getSensor2() {
        expected = 5;
        actual = game.getSensor2();
        assertEquals(expected,actual);
    }

    @Test
    public void getSensor3() {
        expected = 78;
        actual = game.getSensor3();
        assertEquals(expected,actual);
    }

    @Test
    public void getSensor4() {
        expected = 19;
        actual = game.getSensor4();
        assertEquals(expected,actual);
    }

    @Test
    public void getSensor5() {
        expected = 43;
        actual = game.getSensor5();
        assertEquals(expected,actual);
    }
}