package com.buyalskaya.day3.validator;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DataValidatorTest {
    DataValidator dataValidator;

    @BeforeClass
    public void setUp() {
        dataValidator = new DataValidator();
    }

    @Test
    public void validateDataLineTestPositive() {
        String[] line = {"blue", "4", "7"};
        assertTrue(dataValidator.validateDataLine(line));
    }

    @Test
    public void validateDataLineTestNegative() {
        String[] line = {"blue,", "4", "7"};
        assertFalse(dataValidator.validateDataLine(line));
    }

    @DataProvider(name = "dataForValidateIsDouble")
    public Object[][] dataForValidateIsDouble() {
        return new Object[][]{
                {"7", true},
                {"1.5", true},
                {"-1.5", true},
                {"11.17", true},
                {".5",false},
                {"7.", false},
                {"0.1.4", false},
                {"--1.54", false},
                {null, false}
        };
    }

    @Test(dataProvider = "dataForValidateIsDouble")
    public void validateIsDoubleTestParams(String number, boolean expected) {
        boolean actual = dataValidator.validateIsDouble(number);
        assertEquals(actual, expected);
    }
}