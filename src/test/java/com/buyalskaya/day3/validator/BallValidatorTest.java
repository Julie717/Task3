package com.buyalskaya.day3.validator;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BallValidatorTest {
    BallValidator ballValidator;

    @BeforeClass
    public void setUp() {
        ballValidator = new BallValidator();
    }

    @DataProvider(name = "dataForValidateColor")
    public Object[][] dataForValidateColor() {
        return new Object[][]{
                {"red", true},
                {"Green", true},
                {"BROWN", true},
                {"YeLLow", true},
                {"reed", false},
                {null, false},
                {"WHITEE", false},
                {"Brown ", false},
        };
    }

    @Test(dataProvider = "dataForValidateColor")
    public void validateColorTestParams(String color, boolean expected) {
        boolean actual = ballValidator.validateColor(color);
        assertEquals(actual, expected);
    }

    @Test
    public void validateWeightTestPositive() {
        double weight = 1.5;
        assertTrue(ballValidator.validateWeight(weight));
    }

    @Test
    public void validateWeightTestNegative() {
        double weight = 0;
        assertFalse(ballValidator.validateWeight(weight));
    }

    @Test
    public void validateVolumeTestPositive() {
        double volume = 1.5;
        assertTrue(ballValidator.validateVolume(volume));
    }

    @Test
    public void validateVolumeTestNegative() {
        double volume = 25;
        assertFalse(ballValidator.validateVolume(volume));
    }
}