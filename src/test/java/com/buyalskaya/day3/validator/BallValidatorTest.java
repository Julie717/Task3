package com.buyalskaya.day3.validator;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BallValidatorTest {
    BallValidator ballValidator;

    @BeforeClass
    public void setUp() {
        ballValidator = new BallValidator();
    }

    @Test
    public void validateColorTestPositive() {
        String color = "blue";
        assertTrue(ballValidator.validateColor(color));
    }

    @Test
    public void validateColorTestNegative() {
        String color = "bluee";
        assertFalse(ballValidator.validateColor(color));
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