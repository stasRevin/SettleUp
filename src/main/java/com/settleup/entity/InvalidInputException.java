package com.settleup.entity;

import lombok.Getter;

import java.util.List;

public class InvalidInputException extends RuntimeException {

    @Getter
    private List<ErrorDescription> errors;

    public InvalidInputException (List<ErrorDescription> errors) {

        super();
        this.errors = errors;
    }

    public InvalidInputException (String message, List<ErrorDescription> errors) {

        super(message);
        this.errors = errors;
    }

}
