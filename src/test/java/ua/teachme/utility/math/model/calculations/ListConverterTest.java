package ua.teachme.utility.math.model.calculations;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ListConverterTest {

    private List<String> inputData = new ArrayList<>(Arrays.asList(
            "string1",
            "string2",
            "string3",
            "string4",
            "string5"
    ));

    private String expectedData =
            "string1 " +
            "string2 " +
            "string3 " +
            "string4 " +
            "string5";

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testToString() throws Exception {
        String result = ListConverter.toString(inputData);
        assertEquals(expectedData, result);
    }
}