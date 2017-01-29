package com.calculator.extractors;

import com.calculator.delimiters.Delimiter;
import com.calculator.delimiters.DelimiterResult;
import com.calculator.delimiters.DelimiterFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NumbersExtractorImpl implements NumbersExtractor {
    private static final String DELIMITER = ",";

    private final DelimiterFactory delimiterFactory;
    @Autowired
    public NumbersExtractorImpl(DelimiterFactory delimiterFactory) {
        this.delimiterFactory = delimiterFactory;
    }

    @Override
    public List<Integer> extract(String input) {
        Delimiter delimiter = delimiterFactory.getDelimiter(input);
        DelimiterResult delResult = delimiter.extract(input);

        String inputFormattedWithOneDelimiter = formatStringWithOneDelimiter(delResult);

        return convertToInteger(inputFormattedWithOneDelimiter);
    }

    private String formatStringWithOneDelimiter(DelimiterResult delimiterResult) {

        String numbers = delimiterResult.getInputWithoutDelimiterPrefix();

        String numbersWithOneDelimiter = "";
        for (String delimiter : delimiterResult.getDelimiters()) {
            numbersWithOneDelimiter = numbers.replace(delimiter, DELIMITER);
            numbers = numbersWithOneDelimiter;
        }
        return numbersWithOneDelimiter;
    }


    private List<Integer> convertToInteger(String input) {
        String[] inputNumbers=input.split(DELIMITER);
        List<Integer> numbers = new ArrayList<>();
        for (String numberStr : inputNumbers) {
            numbers.add(Integer.valueOf(numberStr));
        }
        return numbers;
    }
}
