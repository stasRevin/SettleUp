package com.settleup.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * This is the ErrorDescription class designed to store the description of the service error.
 * @author srevin
 */
public class ErrorDescription {

    @JsonProperty
    private String errorCode;
    @JsonProperty
    private String field;
    @JsonProperty
    private String message;

    /**
     * This method returns the error code.
     * @return errorCode
     */
    @XmlElement
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * This method sets value of the error code.
     * @param errorCode
     */
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * This method returns the error message.
     * @return message
     */
    @XmlElement
    public String getMessage() {
        return message;
    }

    /**
     * This method sets the value of the error message.
     * @param message
     */
    public void setMessage(String message) {
        this.message = message;
    }

}
