package com.springboot.firstapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.firstapp.model.Country;
import com.springboot.firstapp.repository.CountryRepository;
import com.springboot.firstapp.service.exception.CountryNotFoundException;

@Service
public class CountryService {
	
	@Autowired
	private CountryRepository countryRepository;
	
	@Transactional
	public List<Country> getAllCountries() {
		return countryRepository.findAll();
	}
	
	@Transactional
	public Country findCountryByCode(String countryCode) throws CountryNotFoundException {
		Optional<Country> result = countryRepository.findById(countryCode);
		if (!result.isPresent())
			throw new CountryNotFoundException();
		return result.get();
	}
	
	@Transactional
	public void addCountry(Country country) {
		countryRepository.save(country);
	}
	
	@Transactional
	public void updateCountry(String countryCode,String countryName) throws CountryNotFoundException {
		Optional<Country> result = countryRepository.findById(countryCode);
		if (result.isEmpty())
			throw new CountryNotFoundException();
		Country country = result.get();
		country.setName(countryName);
		countryRepository.save(country);
	}
	
	@Transactional
	public void deleteCountry(String countryCode) {
		countryRepository.deleteById(countryCode);
	}
	
}
