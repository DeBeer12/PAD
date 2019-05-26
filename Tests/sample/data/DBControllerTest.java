package sample.data;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DBControllerTest {

    private DBController controller;

    @Before
    public void setUp() throws Exception {
        controller = new DBController();

    }

    @Test
    public void getConnectionStatus() {
        String expected = "connection succesfull";
        String actual = controller.getConnectionStatus();
        assertEquals(expected,actual);
    }
}