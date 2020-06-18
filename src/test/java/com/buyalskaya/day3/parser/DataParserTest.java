package com.buyalskaya.day3.parser;

import com.buyalskaya.day3.exception.ProjectException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DataParserTest {
    DataParser dataParser;

    @BeforeClass
    public void setUp() {
        dataParser = new DataParser();
    }

    @Test
    public void parseOneLineTestPositive() {
        String parameter = "blue 1 5";
        try {
            String[] actual = dataParser.parseOneLine(parameter);
            String[] expected = {"blue", "1", "5"};
            assertEquals(actual, expected);
        } catch (ProjectException ex) {
            fail("Data format is incorrect");
        }
    }

    @Test
    public void parseOneLineTestNegativeColor() {
        String parameter = "greeen 1.4 12.1";
        assertThrows(ProjectException.class, () -> dataParser.parseOneLine(parameter));
    }

    @Test
    public void parseOneLineTestNegativeWeight() {
        String parameter = "green -1.4 12";
        assertThrows(ProjectException.class, () -> dataParser.parseOneLine(parameter));
    }

    @Test
    public void parseOneLineTestNegativeVolume() {
        String parameter = "green 1.4 0";
        assertThrows(ProjectException.class, () -> dataParser.parseOneLine(parameter));
    }
}