package com.settleup.entity;

import lombok.Data;
import lombok.Getter;

import java.util.List;

public class ServerSideException extends RuntimeException {

    @Getter
    private List<ErrorDescription> errors;

    public ServerSideException(List<ErrorDescription> errors) {

        super();
        this.errors = errors;
    }

    public ServerSideException(String message, List<ErrorDescription> errors) {

        super(message);
        this.errors = errors;
    }

}
