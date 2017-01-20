package com.calculator.extractors.delimiter;

public interface Delimiter {
    String MULTIPLE_DELIMITER_REGEX = "^//(.+)\\n(.*)$";

    DelimiterExtractorResult extract(String str);
}
