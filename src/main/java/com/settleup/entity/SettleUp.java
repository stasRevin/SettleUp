package com.settleup.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Class to represent settleup entity.
 * To get access via json, xml or text.
 * @author oponomarova
 * @author srevin
 */
@Data
@Entity(name = "SettleUp")
@Table(name = "area_search")
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

    @Getter
    @Setter
    @XmlTransient
    @Column(name = "city_name")
    private String city;

    @Getter
    @Setter
    @XmlTransient
    @Column(name = "county_name")
    private String county;

    @Getter
    @Setter
    @JsonProperty("area")
    @Column(name = "area")
    private String area;

    @Getter
    @Setter
    @XmlTransient
    @Column(name = "activity")
    private String activity;

    @Getter
    @Setter
    @XmlTransient
    @Transient
    private String errorMessage;

    /**
     * Default constructor for the bean class.
     */
    public SettleUp() {

    }

    /**
     * This method returns the id.
     * @return id The id of the SettleUp entity
     */
    public int getId() {
        return id;
    }

    /**
     * This method sets the id.
     * @param id The id of the SettleUp entity.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * This method returns the rent price for a studio apartment.
     * @return rent_0
     */
    @XmlElement
    public int getRent_0() {
        return rent_0;
    }

    /**
     * This method sets the rent price fort a studio apartment.
     * @param rent_0
     */
    public void setRent_0(int rent_0) {
        this.rent_0 = rent_0;
    }

    /**
     * This method returns the rent price for one bedroom apartment.
     * @return rent_1
     */
    @XmlElement
    public int getRent_1() {
        return rent_1;
    }

    /**
     * This method sets the rent price for one bedroom apartment.
     * @param rent_1
     */
    public void setRent_1(int rent_1) {
        this.rent_1 = rent_1;
    }

    /**
     * This method returns the rent price for two bedroom apartment.
     * @return rent_2
     */
    @XmlElement
    public int getRent_2() {
        return rent_2;
    }

    /**
     * This method sets the rent price for the two bedroom apartment.
     * @param rent_2
     */
    public void setRent_2(int rent_2) {
        this.rent_2 = rent_2;
    }

    /**
     * This method returns the rent price for the three bedroom apartment.
     * @return rent_3
     */
    @XmlElement
    public int getRent_3() {
        return rent_3;
    }

    /**
     * This method sets the rent price for the three bedroom apartment.
     * @param rent_3
     */
    public void setRent_3(int rent_3) {
        this.rent_3 = rent_3;
    }

    /**
     * This method returns the rent price for the four bedroom apartment.
     * @return rent_4
     */
    @XmlElement
    public int getRent_4() {
        return rent_4;
    }

    /**
     * This method sets the rent price for the four bedroom apartment.
     * @param rent_4
     */
    public void setRent_4(int rent_4) {
        this.rent_4 = rent_4;
    }

    /**
     * This method return the state abbreviation.
     * @return stateAlpha
     */
    @XmlElement
    public String getStateAlpha() {
        return stateAlpha;
    }

    /**
     * This method sets the state abbreviation.
     * @param stateAlpha
     */
    public void setStateAlpha(String stateAlpha) {
        this.stateAlpha = stateAlpha;
    }

}