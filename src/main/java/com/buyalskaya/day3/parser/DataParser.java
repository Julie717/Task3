package com.buyalskaya.day3.parser;

import com.buyalskaya.day3.exception.InputDataException;
import com.buyalskaya.day3.validator.DataValidator;

import java.util.List;

public class DataParser {
    public static final String REGEX_DELIMITER = "\\s+";
    public static final String INCORRECT_PARAMETERS = "Parameters of balls are incorrect";

    public String[] parseOneLine(String data) throws InputDataException {
        String[] parseData = data.split(REGEX_DELIMITER);
        DataValidator dataValidator = new DataValidator();
        if (!dataValidator.validateDataLine(parseData)) {
            throw new InputDataException(INCORRECT_PARAMETERS);
        }
        return parseData;
    }

    public String[][] parseAllData(List<String> data) throws InputDataException {
        int size = data.size();
        String[][] resultData = new String[size][];
        for (int i = 0; i < size; i++) {
            resultData[i] = parseOneLine(data.get(i));
        }
        return resultData;
    }
}
