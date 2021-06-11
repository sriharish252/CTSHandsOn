package com.springboot.firstapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.springboot.firstapp.model.Country;
import com.springboot.firstapp.service.CountryService;
import com.springboot.firstapp.service.exception.CountryNotFoundException;

@SpringBootApplication
public class OrmLearnApplication {

	private static CountryService countryService;
	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

	private static void testGetAllCountries() {
		LOGGER.info("Start");
		List<Country> countries = countryService.getAllCountries();
		LOGGER.debug("countries={}", countries);
		LOGGER.info("End");
	}

	private static void getAllCountriesTest() {
		LOGGER.info("Start");
		Country country;
		try {
			country = countryService.findCountryByCode("IN");
			LOGGER.debug("Country:{}", country);
		} catch (CountryNotFoundException e) {
			e.printStackTrace();
		}
		LOGGER.info("End");
	}

	private static void testAddCountry() {
		LOGGER.info("Start");
		Country country = new Country();
		country.setCode("IN");
		country.setName("INDIA");
		countryService.addCountry(country);
		LOGGER.info("Checking if added country is present");
		try {
			LOGGER.debug("Country:{}", countryService.findCountryByCode("IN"));
		} catch (CountryNotFoundException e) {
			e.printStackTrace();
		}
		LOGGER.info("End");
	}
	
	private static void testUpdateCountry() {
		LOGGER.info("Start");
		Country country_check;
		try {
			countryService.updateCountry("IN", "INDONESIA");
			country_check = countryService.findCountryByCode("IN");
			LOGGER.debug("Country:{}", country_check);
		} catch (CountryNotFoundException e) {
			e.printStackTrace();
		}
		LOGGER.info("End");
	}
	
	private static void testDeleteCountry() {
		LOGGER.info("Start");
		Country country_check;
		try {
			countryService.deleteCountry("IN");
			country_check = countryService.findCountryByCode("IN");
			LOGGER.debug("Country:{}", country_check);
		} catch (CountryNotFoundException e) {
			LOGGER.info("Country deleted successfully");
		}
		LOGGER.info("End");
	}
	

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		countryService = context.getBean(CountryService.class);
		//getAllCountriesTest();
		//testAddCountry();
		//testUpdateCountry();
		//testDeleteCountry();
		LOGGER.info("Inside main");
	}
}
