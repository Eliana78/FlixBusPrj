package com.spring.FlixBus.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.FlixBus.entities.Category;
import com.spring.FlixBus.entities.Voyage;


@Repository
public interface VoyageRepo extends JpaRepository<Voyage, Integer> {

	List<Voyage> findVoyageByCategory(Category category);
	
	Optional<Voyage> findVoyageById(int id);
	
	
	@Query(value="SELECT *FROM voyages WHERE id BETWEEN 1 AND 6", nativeQuery=true)
	List<Voyage> findFirstSixVoyage();
	
}
