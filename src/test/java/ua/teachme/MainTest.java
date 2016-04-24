package ua.teachme;

import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void testCreateSpringContext() throws Exception {
        Main.createSpringContext();
        assertNotNull(Main.getSpringContext());
    }

    @Test
    public void testCloseSpringContext() throws Exception {
        Main.createSpringContext();
        Main.closeSpringContext();
        assertNull(Main.getSpringContext());
    }

    @Test
    public void testGetSpringContext() throws Exception {
        Main.createSpringContext();
        assertNotNull(Main.getSpringContext());
    }
}