package com.settleup.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

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

    @JsonProperty("state_alpha")
    @Column(name = "state_alpha")
    private String stateAlpha;

    @Column(name = "city_name")
    private String city;

    @Column(name = "county_name")
    private String county;

    @JsonProperty("area")
    @Column(name = "area")
    private String area;

    @Column(name = "activity")
    private String activity;


    public SettleUp() {

    }

    @XmlElement
    public int getRent_0() {
        return rent_0;
    }

    @XmlElement
    public int getRent_1() {
        return rent_1;
    }

    @XmlElement
    public int getRent_2() {
        return rent_2;
    }

    @XmlElement
    public int getRent_3() {
        return rent_3;
    }

    @XmlElement
    public int getRent_4() {
        return rent_4;
    }

    @XmlElement
    public String getStateAlpha() {
        return stateAlpha;
    }

    @XmlElement
    public String getArea() {
        return area;
    }

}
