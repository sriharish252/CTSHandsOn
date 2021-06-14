package com.springboot.firstapp;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.springboot.firstapp.model.Country;
import com.springboot.firstapp.repository.CountryRepository;

@SpringBootTest
class OrmLearnApplicationTests {
	
	@Autowired
	CountryRepository countryRepo;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void testGetAllMatchingNames() {
		System.out.println("Starting testGetAllMatchingNames ");
		List<Country> result = countryRepo.getAllMatchingNames("ou");
		for (Country country : result) {
			System.out.println(country.getCode()+" - "+country.getName());
		}
		System.out.println("testGetAllMatchingNames Testing Done");
	}
	
	@Test
	public void testgetAllMatchingNamesSortedByName() {
		System.out.println("Starting testGetAllMatchingNamesSortedByName ");
		List<Country> result = countryRepo.getAllMatchingNamesSortedByName("ou", Sort.by(Direction.ASC,"name"));
		for (Country country : result) {
			System.out.println(country.getCode()+" - "+country.getName());
		}
		System.out.println("testGetAllMatchingNamesSortdByName Testing Done");
	}
	

}
