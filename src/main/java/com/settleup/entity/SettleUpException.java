package com.settleup.entity;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * This is a SettleUpException class designed to hold a list of errors to produce a well formed XML response with errors.
 * @author srevin
 */
@XmlRootElement(name = "errors")
@Data
public class SettleUpException {

    private List<ErrorDescription> errors;

}
