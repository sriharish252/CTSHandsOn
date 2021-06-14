package com.springboot.firstapp.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.firstapp.model.Country;

@Repository
public interface CountryRepository extends JpaRepository <Country, String> {
	
	@Query("SELECT c FROM Country c WHERE co_name LIKE %?1%")
	List<Country> getAllMatchingNames(String name);
	
	@Query("SELECT c FROM Country c WHERE co_name LIKE %?1%")
	List<Country> getAllMatchingNamesSortedByName(String name,Sort sort);
	
	
	
}
