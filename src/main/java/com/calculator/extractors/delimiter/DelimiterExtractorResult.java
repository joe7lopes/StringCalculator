package com.calculator.extractors.delimiter;

import java.util.List;

public class DelimiterExtractorResult {

    private List<String> delimiters;
    private String cleanString;

    public DelimiterExtractorResult(List<String> delimiters, String cleanString) {
        this.delimiters = delimiters;
        this.cleanString = cleanString;
    }

    public List<String> getDelimiters() {
        return delimiters;
    }

    public String getCleanString() {
        return cleanString;
    }
}
