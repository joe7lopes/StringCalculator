package com.calculator.delimiters;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Collections.singletonList;

@Component
class SingleOptionalDelimiter implements Delimiter {

    private static final String SINGLE_OPTIONAL_DELIMITER_REGEX = "^//(.+)\\n(.*)";

    @Override
    public DelimiterResult extract(String input) {
        Pattern p = Pattern.compile(SINGLE_OPTIONAL_DELIMITER_REGEX);
        Matcher m = p.matcher(input);
        String delimiter = "";
        String inputWithoutDelimiter = "";
        if (m.matches()) {
            delimiter = m.group(1);
            inputWithoutDelimiter = m.group(2);
        }
        return new DelimiterResult(singletonList(delimiter), inputWithoutDelimiter);
    }
}
