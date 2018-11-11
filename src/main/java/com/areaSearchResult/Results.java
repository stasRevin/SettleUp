package com.areaSearchResult;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Results{

	@JsonProperty("rent_1")
	private int rent1;

	@JsonProperty("area")
	private String area;

	@JsonProperty("rent_0")
	private int rent0;

	@JsonProperty("activity")
	private String activity;

	@JsonProperty("city")
	private String city;

	@JsonProperty("rent_4")
	private int rent4;

	@JsonProperty("rent_3")
	private int rent3;

	@JsonProperty("rent_2")
	private int rent2;

	@JsonProperty("county")
	private String county;

	@JsonProperty("stateAlpha")
	private String stateAlpha;

	@JsonProperty("id")
	private int id;

	public void setRent1(int rent1){
		this.rent1 = rent1;
	}

	public int getRent1(){
		return rent1;
	}

	public void setArea(String area){
		this.area = area;
	}

	public String getArea(){
		return area;
	}

	public void setRent0(int rent0){
		this.rent0 = rent0;
	}

	public int getRent0(){
		return rent0;
	}

	public void setActivity(String activity){
		this.activity = activity;
	}

	public String getActivity(){
		return activity;
	}

	public void setCity(String city){
		this.city = city;
	}

	public String getCity(){
		return city;
	}

	public void setRent4(int rent4){
		this.rent4 = rent4;
	}

	public int getRent4(){
		return rent4;
	}

	public void setRent3(int rent3){
		this.rent3 = rent3;
	}

	public int getRent3(){
		return rent3;
	}

	public void setRent2(int rent2){
		this.rent2 = rent2;
	}

	public int getRent2(){
		return rent2;
	}

	public void setCounty(String county){
		this.county = county;
	}

	public String getCounty(){
		return county;
	}

	public void setStateAlpha(String stateAlpha){
		this.stateAlpha = stateAlpha;
	}

	public String getStateAlpha(){
		return stateAlpha;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"Results{" + 
			"rent_1 = '" + rent1 + '\'' + 
			",area = '" + area + '\'' + 
			",rent_0 = '" + rent0 + '\'' + 
			",activity = '" + activity + '\'' + 
			",city = '" + city + '\'' + 
			",rent_4 = '" + rent4 + '\'' + 
			",rent_3 = '" + rent3 + '\'' + 
			",rent_2 = '" + rent2 + '\'' + 
			",county = '" + county + '\'' + 
			",stateAlpha = '" + stateAlpha + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}