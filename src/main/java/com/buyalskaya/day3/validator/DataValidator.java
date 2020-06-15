package com.buyalskaya.day3.validator;

import java.util.ArrayList;
import java.util.Arrays;

public class DataValidator {
    public static final String REGEX_DELIMITER = "\\s+";

    public boolean validateDataLine(String dataLine) {
        ArrayList<String> data = new ArrayList<>(Arrays.asList(dataLine.split(REGEX_DELIMITER)));
        boolean validate;
        BallValidator ballValidator = new BallValidator();
        if (ballValidator.validateColor(data.get(0)) &&
                validateIsDouble(data.get(1))) {
            double weight = Double.parseDouble(data.get(1));
            validate = ballValidator.validateWeight(weight);
        } else {
            validate = false;
        }
        return validate;
    }

    public boolean validateIsDouble(String number) {
        if (number == null) {
            return false;
        }
        boolean validate;
        try {
            Double.parseDouble(number);
            validate = true;
        } catch (NumberFormatException ex) {
            validate = false;
        }
        return validate;
    }
}