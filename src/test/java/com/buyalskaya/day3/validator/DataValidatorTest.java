package com.buyalskaya.day3.validator;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DataValidatorTest {
    DataValidator dataValidator = new DataValidator();

    @BeforeClass
    public void setUp() {
        dataValidator = new DataValidator();
    }

    @Test
    public void validateDataLineTestPositive() {
        String line = "blue 4";
        assertTrue(dataValidator.validateDataLine(line));
    }

    @Test
    public void validateDataLineTestNegative() {
        String line = "blue, 4";
        assertFalse(dataValidator.validateDataLine(line));
    }

    @DataProvider(name = "dataForValidateIsDouble")
    public Object[][] dataForValidateIsDouble() {
        return new Object[][]{
                {"15.5", true},
                {"1E-5", true},
                {"7", true},
                {"point", false},
                {"1.5.4", false},
                {null, false}
        };
    }

    @Test(dataProvider = "dataForValidateIsDouble")
    public void validateIsDoubleTestParams(String number, boolean expected) {
        boolean actual = dataValidator.validateIsDouble(number);
        assertEquals(actual, expected);
    }
}
