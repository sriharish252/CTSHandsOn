package com.springboot.firstapp.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.firstapp.model.Country;

@Repository
public interface CountryRepository extends JpaRepository <Country, String> {
	
}
