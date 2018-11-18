package com.settleup.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonPropertyOrder({"errorCode", "field", "message"})
public class ErrorDescription {

    private String errorCode;
    private String field;
    private String message;
}
