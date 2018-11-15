package com.settleup.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import javax.persistence.*;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "areas")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity(name = "SettleUp")
@Table(name = "area_search")
@Data
public class SettleUp {


    @XmlID
    @Id
    private int id;

    @XmlElement
    @JsonProperty("rent_0")
    @Column(name = "rent_0")
    private int rent_0;

    @XmlElement
    @JsonProperty("rent_1")
    @Column(name = "rent_1")
    private int rent_1;

    @XmlElement
    @JsonProperty("rent_2")
    @Column(name = "rent_2")
    private int rent_2;

    @XmlElement
    @JsonProperty("rent_3")
    @Column(name = "rent_3")
    private int rent_3;

    @XmlElement
    @JsonProperty("rent_4")
    @Column(name = "rent_4")
    private int rent_4;

    @XmlElement
    @JsonProperty("stateAlpha")
    @Column(name = "state_alpha")
    private String stateAlpha;

    @XmlElement
    @XmlTransient
    @Column(name = "city_name")
    private String city;

    @XmlElement
    @XmlTransient
    @Column(name = "county_name")
    private String county;

    @XmlElement
    @JsonProperty("area")
    @Column(name = "area")
    private String area;

    @XmlElement
    @XmlTransient
    @Column(name = "activity")
    private String activity;


    public SettleUp() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @XmlElement
    public int getRent_0() {
        return rent_0;
    }

    public void setRent_0(int rent_0) {
        this.rent_0 = rent_0;
    }

    @XmlElement
    public int getRent_1() {
        return rent_1;
    }

    public void setRent_1(int rent_1) {
        this.rent_1 = rent_1;
    }

    @XmlElement
    public int getRent_2() {
        return rent_2;
    }

    public void setRent_2(int rent_2) {
        this.rent_2 = rent_2;
    }

    @XmlElement
    public int getRent_3() {
        return rent_3;
    }

    public void setRent_3(int rent_3) {
        this.rent_3 = rent_3;
    }

    @XmlElement
    public int getRent_4() {
        return rent_4;
    }

    public void setRent_4(int rent_4) {
        this.rent_4 = rent_4;
    }

    @XmlElement
    public String getStateAlpha() {
        return stateAlpha;
    }

    public void setStateAlpha(String stateAlpha) {
        this.stateAlpha = stateAlpha;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }
}
