package com.calculator.delimiters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class DelimiterFactory {

    private SimpleDelimiter simpleDelimiter;
    private SingleOptionalDelimiter singleOptionalDelimiter;
    private MultipleOptionalDelimiter multipleOptionalDelimiter;


    public DelimiterFactory() {
    }

    @Autowired
    public DelimiterFactory(SimpleDelimiter simpleDelimiter, SingleOptionalDelimiter singleOptionalDelimiter, MultipleOptionalDelimiter multipleOptionalDelimiter) {
        this.simpleDelimiter = simpleDelimiter;
        this.singleOptionalDelimiter = singleOptionalDelimiter;
        this.multipleOptionalDelimiter = multipleOptionalDelimiter;
    }

    public Delimiter getDelimiter(String criteria) {
        Delimiter delimiter = simpleDelimiter;

        if (criteria.startsWith("//")) {
            delimiter = getOptionalDelimiter(criteria);
        }

        return delimiter;
    }


    private Delimiter getOptionalDelimiter(String criteria) {
        int numberOfMatches = getNumberOfMatches(criteria);
        if (numberOfMatches > 1) {
            return multipleOptionalDelimiter;
        }
        return singleOptionalDelimiter;
    }

    private int getNumberOfMatches(String criteria) {
        Pattern p = Pattern.compile("(?<=\\[)([^\\]]+)(?=\\])");
        Matcher m = p.matcher(criteria);
        int count = 0;
        while (m.find()) {
            count++;
        }

        return count;
    }
}
