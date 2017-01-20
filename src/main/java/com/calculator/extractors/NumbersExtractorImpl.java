package com.calculator.extractors;

import com.calculator.extractors.delimiter.Delimiter;
import com.calculator.extractors.delimiter.DelimiterExtractorResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NumbersExtractorImpl implements NumbersExtractor {
    private static final String DELIMITER = "&";
    private Delimiter delimiter;

    @Autowired
    public NumbersExtractorImpl(Delimiter delimiter) {
        this.delimiter = delimiter;
    }

    @Override
    public List<Integer> extract(String str) {

        DelimiterExtractorResult delResult = delimiter.extract(str);

        String strFormattedWithOneDelimiter = formatStringWithOneDelimiter(delResult);

        return convertToInteger(strFormattedWithOneDelimiter.split(DELIMITER));
    }

    private String formatStringWithOneDelimiter(DelimiterExtractorResult delResult) {

        String numbersDelimited= delResult.getCleanString();

        String numbersWithOneDelimiter = "";
        for (String delimiter : delResult.getDelimiters()) {
            numbersWithOneDelimiter = numbersDelimited.replace(delimiter, DELIMITER);
            numbersDelimited = numbersWithOneDelimiter;
        }
        return numbersWithOneDelimiter;
    }


    private List<Integer> convertToInteger(String[] numbersArr) {
        List<Integer> numbers = new ArrayList<>();
        for (String numberStr : numbersArr) {
            numbers.add(Integer.valueOf(numberStr));
        }
        return numbers;
    }
}
