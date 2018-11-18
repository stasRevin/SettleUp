package com.settleup.entity;

import lombok.Data;
import lombok.Getter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "errors")
@Data
public class SettleUpException {

    private List<ErrorDescription> errors;

}
