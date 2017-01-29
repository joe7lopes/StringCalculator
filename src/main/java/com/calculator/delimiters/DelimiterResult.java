package com.calculator.delimiters;

import java.util.List;

public class DelimiterResult {

    private final List<String> delimiters;
    private final String inputWithoutDelimiterPrefix;

    public DelimiterResult(List<String> delimiters, String inputWithoutDelimiterPrefix) {
        this.delimiters = delimiters;
        this.inputWithoutDelimiterPrefix = inputWithoutDelimiterPrefix;
    }

    public List<String> getDelimiters() {
        return delimiters;
    }

    public String getInputWithoutDelimiterPrefix() {
        return inputWithoutDelimiterPrefix;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DelimiterResult result = (DelimiterResult) o;

        return delimiters.equals(result.delimiters) && inputWithoutDelimiterPrefix.equals(result.inputWithoutDelimiterPrefix);

    }

    @Override
    public int hashCode() {
        int result = delimiters.hashCode();
        result = 31 * result + inputWithoutDelimiterPrefix.hashCode();
        return result;
    }
}
