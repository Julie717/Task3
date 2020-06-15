package com.buyalskaya.day3.parser;

import com.buyalskaya.day3.exception.InputDataException;
import com.buyalskaya.day3.validator.DataValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataParser {
    public static final String REGEX_DELIMITER = "\\s+";
    public static final String INCORRECT_PARAMETERS = "Parameters of balls are incorrect";

    public List<List<String>> parseData(List<String> data) throws InputDataException {
        List<List<String>> resultData = new ArrayList<>();
        for (String element : data) {
            DataValidator dataValidator = new DataValidator();
            if (dataValidator.validateDataLine(element)) {
                resultData.add(new ArrayList<>(Arrays.asList(element.split(REGEX_DELIMITER))));
            } else {
                throw new InputDataException(INCORRECT_PARAMETERS);
            }
        }
        return resultData;
    }
}
