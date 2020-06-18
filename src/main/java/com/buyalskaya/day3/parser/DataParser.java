package com.buyalskaya.day3.parser;

import com.buyalskaya.day3.exception.ProjectException;
import com.buyalskaya.day3.validator.DataValidator;

import java.util.List;

public class DataParser {
    public static final String REGEX_DELIMITER = "\\s+";

    public String[] parseOneLine(String data) throws ProjectException {
        String[] parseData = data.split(REGEX_DELIMITER);
        DataValidator dataValidator = new DataValidator();
        if (!dataValidator.validateDataLine(parseData)) {
            throw new ProjectException("Parameters of balls are incorrect");
        }
        return parseData;
    }

    public String[][] parseAllData(List<String> data) throws ProjectException {
        int size = data.size();
        String[][] resultData = new String[size][];
        for (int i = 0; i < size; i++) {
            resultData[i] = parseOneLine(data.get(i));
        }
        return resultData;
    }
}