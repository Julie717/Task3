package com.buyalskaya.day3.parser;

import com.buyalskaya.day3.exception.InputDataException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class DataParserTest {
    public static final String EXCEPTION_MESSAGE = "Data format is incorrect";
    DataParser dataParser = new DataParser();

    @BeforeClass
    public void setUp() {
        dataParser = new DataParser();
    }

    @Test
    public void dataParserTestPositive() {
        List<String> parameter = Arrays.asList(new String[]{"blue 1", "red 1.4", "yellow 5"});
        try {
            List<List<String>> actual = dataParser.parseData(parameter);
            List<List<String>> expected = new ArrayList<>();
            expected.add(Arrays.asList(new String[]{"blue", "1"}));
            expected.add(Arrays.asList(new String[]{"red", "1.4"}));
            expected.add(Arrays.asList(new String[]{"yellow", "5"}));
            assertEquals(actual, expected);
        } catch (InputDataException ex) {
            fail(EXCEPTION_MESSAGE);
        }
    }

    @Test
    public void dataParserTestNegativeColor() {
        List<String> parameter = Arrays.asList(new String[]{"blue 1", "greeen 1.4", "yellow 5"});
        assertThrows(InputDataException.class, () -> dataParser.parseData(parameter));
    }

    @Test
    public void dataParserTestNegativeWeight() {
        List<String> parameter = Arrays.asList(new String[]{"blue 11.4.7", "green 1.4", "yellow 5"});
        assertThrows(InputDataException.class, () -> dataParser.parseData(parameter));
    }
}
