 package com.example.demo.controllers;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.beans.Country;
import com.example.demo.services.CountryService;

@RestController

public class CountryController {
//Here Why we use ResponseEntitiy , to use httprequest included http status code 
	//CountryService countryService new CountryService (); instead of the this we use Autowired , so new keyword is not needed.
	@Autowired
	CountryService countryService;
	
	@GetMapping("/getcountries")
	public  List<Country> getCountries() {
		
		return countryService.getAllCountries();
	}
	
	@GetMapping("/getcountries/{id}")
	public  ResponseEntity<Country> getContryById(@PathVariable (value ="id") int id) {
		try {
		Country country =countryService.getCountryById(id);
		return new ResponseEntity<Country>(country,HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
		}
		
		
	}
	
	@GetMapping("/getcountries/countryname")
	
	public ResponseEntity<Country> GetCoutryByName(@RequestParam (value ="name") String countryName ) {
		try {
			Country country =countryService.getCountryByName(countryName);
			return new ResponseEntity<Country>(country,HttpStatus.OK);
			}
			catch(Exception e) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
			}
			
		
	}
	
	@PostMapping("/addcountry")
	public Country addCountry(@RequestBody Country country) {
		
		return countryService.addcountry(country);
	}
	
	@PutMapping("/updatecountry/{id}")
	public ResponseEntity<Country> updateCountry(@PathVariable(value ="id")int id ,@RequestBody Country country) {
		
		try {
		 Country existCountry =countryService.getCountryById(id);
		 existCountry.setCountryname(country.getCountryname());
		 existCountry.setCountryname(country.getCountryCapital());
		 
		 Country updated_country = countryService.updateCountry(existCountry);
		 return new ResponseEntity<Country>(updated_country,HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT); 
		}
		

	}
	
	@DeleteMapping("/deletecountry/{id}")
	public AddResponse deleteCountry(@PathVariable (value="id") int id) {
		
		return countryService.deleteCountry(id);
	}
	
	
	
}
