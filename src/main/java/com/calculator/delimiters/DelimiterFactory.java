package com.calculator.delimiters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DelimiterFactory {

    private final SimpleDelimiter simpleDelimiter;
    private final SingleOptionalDelimiter singleOptionalDelimiter;
    private final MultipleOptionalDelimiter multipleOptionalDelimiter;

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
        if (criteria.startsWith("//[")) {
            return multipleOptionalDelimiter;
        }
        return singleOptionalDelimiter;
    }

}
