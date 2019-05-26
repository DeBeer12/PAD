package sample.models;

import org.junit.Before;
import org.junit.Test;
import sample.data.DBController;

import static org.junit.Assert.*;

public class GameTest {

    private Game game;
    private DBController controller;

    @Before
    public void setUp() throws Exception {
        controller = new DBController();
        game = controller.getGameDummy();
    }

    @Test
    public void getId() {
        int expected = 1;
        int actual = game.getId();
        assertEquals(expected,actual);
    }

    @Test
    public void getSensor1() {
        int expected = 1;
        int actual = game.getSensor1();
        assertEquals(expected,actual);
    }

    @Test
    public void getSensor2() {
        int expected = 1;
        int actual = game.getSensor2();
        assertEquals(expected,actual);
    }

    @Test
    public void getSensor3() {
        int expected = 1;
        int actual = game.getSensor3();
        assertEquals(expected,actual);
    }

    @Test
    public void getSensor4() {
        int expected = 1;
        int actual = game.getSensor4();
        assertEquals(expected,actual);
    }

    @Test
    public void getSensor5() {
        int expected = 1;
        int actual = game.getSensor5();
        assertEquals(expected,actual);
    }
}