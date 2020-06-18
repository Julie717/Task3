package com.buyalskaya.day3.validator;

import java.util.regex.Pattern;

public class DataValidator {
    private static final String CHECK_NUMBER = "-?(\\d+)(\\.\\d+)?";

    public boolean validateDataLine(String[] parameter) {
        String colorString = parameter[0];
        String weightString = parameter[1];
        String volumeString = parameter[2];
        boolean validate;
        BallValidator ballValidator = new BallValidator();
        if (ballValidator.validateColor(colorString) &&
                validateIsDouble(weightString) &&
                validateIsDouble(volumeString)) {
            double weight = Double.parseDouble(parameter[1]);
            double volume = Double.parseDouble(parameter[2]);
            validate = ballValidator.validateWeight(weight) && ballValidator.validateVolume(volume);
        } else {
            validate = false;
        }
        return validate;
    }

    public boolean validateIsDouble(String number) {
        if (number == null) {
            return false;
        }
        return Pattern.matches(CHECK_NUMBER, number);
    }
}