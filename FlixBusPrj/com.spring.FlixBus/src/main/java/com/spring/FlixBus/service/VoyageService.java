package com.spring.FlixBus.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;

import com.spring.FlixBus.entities.Category;
import com.spring.FlixBus.entities.Voyage;

public interface VoyageService {

	
	List<Voyage> getVoyageByCategory(Category category);
	
	Optional<Voyage> getVoyageById(int id);
	
	
	@Query(value="SELECT *FROM voyages WHERE id BETWEEN 1 AND 6", nativeQuery=true)
	List<Voyage> getFirstSixVoyage();
	
	
	List <Voyage> getAllVoyage();

	Voyage addVoyage(Voyage voyage);
	
	Voyage updateVoyage(Voyage voyage);
	
	void deleteVoyage(Voyage voyage);
	
}


