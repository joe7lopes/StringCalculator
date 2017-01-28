package com.calculator.delimiters;

import java.util.List;

public class DelimiterExtractorResult {

    private final List<String> delimiters;
    private final String cleanString;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DelimiterExtractorResult result = (DelimiterExtractorResult) o;

        return delimiters.equals(result.delimiters) && cleanString.equals(result.cleanString);

    }

    @Override
    public int hashCode() {
        int result = delimiters.hashCode();
        result = 31 * result + cleanString.hashCode();
        return result;
    }
}
