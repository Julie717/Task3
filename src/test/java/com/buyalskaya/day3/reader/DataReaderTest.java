package com.buyalskaya.day3.reader;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class DataReaderTest {
    DataReader dataReader = new DataReader();

    @BeforeClass
    public void setUp() {
        dataReader = new DataReader();
    }

    @Test
    public void readDataTestPositive() {
        String filePath = "resources/inputBallParameter.txt";
        List<String> actual = dataReader.readData(filePath);
        List<String> expected = Arrays.asList(new String[]{"green    5",
                "Blue     2",
                "yellow   1.5",
                "red      4.1",
                "blue     5.5"});
        assertEquals(actual,expected);
    }

    @Test
    public void readDataTestNegative() {
        String filePath = "resources/input.txt";
        assertThrows(RuntimeException.class, () -> dataReader.readData(filePath));
    }
}
