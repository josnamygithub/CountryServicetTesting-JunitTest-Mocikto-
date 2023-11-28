package com.example.demo.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.beans.Country;
import com.example.demo.controllers.AddResponse;
import com.example.demo.repositories.CountryRepository;


@Service
 public class CountryService {

	@Autowired
	CountryRepository countryrep ;
	
	
	public List<Country> getAllCountries() {
		return countryrep.findAll();
	}
	 
	
	public Country getCountryById(int id) {
		 return countryrep.findById(id).get();
		
		}
	
	public Country getCountryByName (String countryname) {
		
		List<Country> countries =countryrep.findAll();//storing in the form of objects
		Country country = null;
		
		for(Country con :countries) {
			if(con.getCountryname().equalsIgnoreCase(countryname))
				country =con;
				}
		return country;
		
	} 

	public  int getMaxId() {
	
		return countryrep.findAll().size()+1;
	}
	
	public Country addcountry(Country country) {
		
		country.setId(getMaxId());
		countryrep.save(country);
		return country;
		
	}
	
	public Country updateCountry(Country country) {
		
		countryrep.save(country);
		return country;
	}
	
	public AddResponse  deleteCountry(int id) {
		
		countryrep.deleteById(id);
		AddResponse res = new AddResponse();
		res.setId(id);
		res.setMsg("Country deleted");
		return res;
	
		
	}
}
