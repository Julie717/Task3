package com.buyalskaya.day3.validator;

public class DataValidator {

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