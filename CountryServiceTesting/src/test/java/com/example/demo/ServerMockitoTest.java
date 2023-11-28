package com.example.demo;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.*;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.beans.Country;
import com.example.demo.repositories.CountryRepository;
import com.example.demo.services.CountryService;

@SpringBootTest(classes = {ServerMockitoTest.class}) 
public class ServerMockitoTest {

	//@Mock and @InjectMock are from the mockito
	@Mock
	CountryRepository countryrep ;//Repo is a external dependancy , so we want to mock these classes ,predefined methods are available 

	@InjectMocks
	CountryService countryService; //we want to  call all methods from service , so we using InjectMocks
	
	
		@Test //for executing test method, junit 5 using along with mockito , jupitor is already available in mockito package.
		
		@Order(1) //if we want this method as a first method  we can use order
		public void test_getAllcountries() {
			List<Country> mycountries = new ArrayList<Country>();
			mycountries.add(new Country(1,"India","New Delhi"));
			mycountries.add(new Country(2,"USA","Washigton"));
			
			when(countryrep.findAll()).thenReturn(mycountries);// Mock state ment
			assertEquals(2,countryService.getAllCountries().size()); 
			}
		@Test
		@Order(2)
		public void test_getCountryById() {
//			List<Country> mycountries = new ArrayList<Country>();
//			mycountries.add(new Country(1,"India","New Delhi"));
//			mycountries.add(new Country(2,"USA","Washigton"));
//			int countryId=1;
//			//when(countryrep.findAll()).thenReturn(mycountries);//Mocking
//		    when(countryrep.findById(countryId)).thenReturn(Optional.of(mycountries.get(1)));
//			assertEquals(countryId,countryService.getCountryById(countryId).getId());
//
//		}
		List<Country> mycountries = new ArrayList<Country>();
		mycountries.add(new Country(1,"India","New Delhi")); //index num0
		mycountries.add(new Country(2,"USA","Washington"));//index num1
		int countryId = 2;

		when(countryrep.findById(countryId)).thenReturn(Optional.of(mycountries.get(1)));
		assertEquals(countryId, countryService.getCountryById(countryId).getId());
		}
		
		@Test
		@Order(3)
		public void test_getCountryByName() {
			List<Country> mycountries = new ArrayList<Country>();
			mycountries.add(new Country(1,"India","New Delhi")); //index num0
			mycountries.add(new Country(2,"USA","Washington"));//index num1

			String countryName="India";
			when(countryrep.findAll()).thenReturn(mycountries);
			assertEquals(countryName,countryService.getCountryByName(countryName).getCountryname());
		}
		
		@Test @Order(4)
		public void test_addCountry() {
			Country country = new Country(3,"Germany","Berlin");
			
			when(countryrep.save(country)).thenReturn(country);
			assertEquals(country,countryService.addcountry(country));
		}
		
		
		
}
