package org.example.admin.catalog.domain.exceptions;

import org.example.admin.catalog.domain.validation.Error;

import java.util.List;

public class DomainExceptions extends NoStackTraceException{
    private final List<Error> errors;

    private DomainExceptions(final String aMessage, final List<Error> someErrors) {
        super(aMessage);
        this.errors = someErrors;
    }

    public static DomainExceptions with(final List<Error> someErrors) {
        return new DomainExceptions("", someErrors);
    }

    public static DomainExceptions with(final Error anError) {
        return with(List.of(anError));
    }

    public List<Error> getErrors() {
        return errors;
    }
}
