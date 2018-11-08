package com.settleup.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name = "areas")
@Entity(name = "SettleUp")
@Table(name = "area_search")
@Data
public class SettleUp {

    @Id
    private int id;

    @JsonProperty("rent_0")
    @Column(name = "rent_0")
    private int rent_0;

    @JsonProperty("rent_1")
    @Column(name = "rent_1")
    private int rent_1;

    @JsonProperty("rent_2")
    @Column(name = "rent_2")
    private int rent_2;

    @JsonProperty("rent_3")
    @Column(name = "rent_3")
    private int rent_3;

    @JsonProperty("rent_4")
    @Column(name = "rent_4")
    private int rent_4;

    @JsonProperty("stateAlpha")
    @Column(name = "state_alpha")
    private String stateAlpha;

    @XmlTransient
    @Column(name = "city_name")
    private String city;

    @XmlTransient
    @Column(name = "county_name")
    private String county;

    @JsonProperty("area")
    @Column(name = "area")
    private String area;

    @XmlTransient
    @Column(name = "activity")
    private String activity;


    public SettleUp() {

    }

}
