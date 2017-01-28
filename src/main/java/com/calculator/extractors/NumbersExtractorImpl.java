package com.calculator.extractors;

import com.calculator.delimiters.Delimiter;
import com.calculator.delimiters.DelimiterExtractorResult;
import com.calculator.delimiters.DelimiterFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NumbersExtractorImpl implements NumbersExtractor {
    private static final String DELIMITER = "&";

    private DelimiterFactory delimiterFactory;
    @Autowired
    public NumbersExtractorImpl(DelimiterFactory delimiterFactory) {
        this.delimiterFactory = delimiterFactory;
    }

    @Override
    public List<Integer> extract(String str) {
        //TODO try to refactor
        Delimiter delimiter = delimiterFactory.getDelimiter(str);
        DelimiterExtractorResult delResult = delimiter.extract(str);

        String strFormattedWithOneDelimiter = formatStringWithOneDelimiter(delResult);

        return convertToInteger(strFormattedWithOneDelimiter.split(DELIMITER));
    }

    private String formatStringWithOneDelimiter(DelimiterExtractorResult delimiterResult) {

        String numbersDelimited = delimiterResult.getCleanString();

        String numbersWithOneDelimiter = "";
        for (String delimiter : delimiterResult.getDelimiters()) {
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
