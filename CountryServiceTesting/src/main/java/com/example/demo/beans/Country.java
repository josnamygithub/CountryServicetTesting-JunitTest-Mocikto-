package com.example.demo.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
//Hiberate validator also used here 
@Entity
@Table(name="Country") //table name and class name need to be same 
public class Country {
	
	@Id // for primary key 
	@Column(name ="id")
	private int id;
	
	@Column(name ="country_name")
	private String countryname;
	
	@Column(name ="capital")
	private String countryCapital;
	
	  public Country() {
	    }

	    public Country(int id, String countryname, String countryCapital) {
	        this.id = id;
	        this.countryname = countryname;
	        this.countryCapital = countryCapital;
	    }
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCountryname() {
		return countryname;
	}
	public void setCountryname(String countryname) {
		this.countryname = countryname;
	}
	public String getCountryCapital() {
		return countryCapital;
	}
	public void setCountryCapital(String countryCapital) {
		this.countryCapital = countryCapital;
	}
	@Override
	public String toString() {
		return "Country [id=" + id + ", countryname=" + countryname + ", countryCapital=" + countryCapital + "]";
	}

}
