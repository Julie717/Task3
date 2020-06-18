package com.buyalskaya.day3.validator;

import com.buyalskaya.day3.entity.Color;

public class BallValidator {

    public static final double BALL_MIN_WEIGHT = 0.1;
    public static final double BALL_MAX_WEIGHT = 15.0;
    public static final double BALL_MIN_VOLUME = 0.1;
    public static final double BALL_MAX_VOLUME = 20.0;

    public boolean validateColor(String color) {
        boolean validate = false;
        if (color != null) {
            String availableColorString;
            for (Color availableColor : Color.values()) {
                availableColorString = availableColor.toString();
                if (availableColorString.equals(color.toUpperCase())) {
                    validate = true;
                }
            }
        }
        return validate;
    }

    public boolean validateWeight(double weight) {
        return (weight >= BALL_MIN_WEIGHT) && (weight <= BALL_MAX_WEIGHT);
    }

    public boolean validateVolume(double volume) {
        return (volume >= BALL_MIN_VOLUME) && (volume <= BALL_MAX_VOLUME);
    }
}