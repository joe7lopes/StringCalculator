package com.calculator.extractors.delimiter;

import org.springframework.stereotype.Component;

@Component
public class DelimiterExtractorFactory {

    public static Delimiter getDelimiter(String str) {
        if (str.startsWith("//[")) {
            return new MultipleDelimiterExtractor();
        } else {
            return new SingleDelimiterExtractor();
        }
    }
}
