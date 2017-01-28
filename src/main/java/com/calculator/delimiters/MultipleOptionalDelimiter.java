package com.calculator.delimiters;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Component
class MultipleOptionalDelimiter implements Delimiter {

    private static final String MULTIPLE_DELIMITER_REGEX = "^//(.+)\n(.*)$";
    private static final String MATCH_BETWEEN_BRACKETS_REGEX = "(?<=\\[)([^\\]]+)(?=\\])";

    @Override
    public DelimiterExtractorResult extract(String input) {

        Pattern p = Pattern.compile(MULTIPLE_DELIMITER_REGEX);
        Matcher m = p.matcher(input);
        List<String> delimiters = new ArrayList<>();
        String clearInput = "";
        if (m.matches()) {
            delimiters = getDelimiters(m.group(1));
            clearInput = m.group(2);
        }

        return new DelimiterExtractorResult(delimiters, clearInput);
    }

    private List<String> getDelimiters(String str) {
        List<String> delimiters = new ArrayList<>();
        Pattern p = Pattern.compile(MATCH_BETWEEN_BRACKETS_REGEX);
        Matcher m = p.matcher(str);
        while (m.find()) {
            delimiters.add(m.group());
        }
        return delimiters;
    }


}
