package com.settleup.client;

import lombok.Data;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

public class XMLResult {

    private int id;

    private int rent_0;

    private int rent_1;

    private int rent_2;

    private int rent_3;

    private int rent_4;

    private String stateAlpha;

    private String city;

    private String county;

    private String area;

    private String activity;


}
