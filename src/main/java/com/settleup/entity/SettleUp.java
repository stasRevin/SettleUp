package com.settleup.entity;


import lombok.Data;
import javax.persistence.*;


@Entity(name = "SettleUp")
@Table(name = "area_search")
@Data
public class SettleUp {

    @Id
    private int id;

    @Column(name = "rent_0")
    private int rent_0;

    @Column(name = "rent_1")
    private int rent_1;

    @Column(name = "rent_2")
    private int rent_2;

    @Column(name = "rent_3")
    private int rent_3;

    @Column(name = "rent_4")
    private int rent_4;

    @Column(name = "state_alpha")
    private String stateAlpha;

    @Column(name = "city_name")
    private String city;

    @Column(name = "county_name")
    private String county;

    @Column(name = "area")
    private String area;

    @Column(name = "activity")
    private String activity;


    public SettleUp() {

    }







}
