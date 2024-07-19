package com.spring.FlixBus.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.FlixBus.entities.Category;
import com.spring.FlixBus.entities.Voyage;
import com.spring.FlixBus.repo.VoyageRepo;

@Service
public class VoyageImpl implements VoyageService {

	@Autowired
	private VoyageRepo voyageRepo;
	
	@Override
	public List<Voyage> getVoyageByCategory(Category category) {
		
		return voyageRepo.findVoyageByCategory(category);
	}

	@Override
	public Optional<Voyage> getVoyageById(int id) {
		
		return voyageRepo.findVoyageById(id);
	}

	@Override
	public List<Voyage> getFirstSixVoyage() {
		
		return voyageRepo.findFirstSixVoyage();
	}

	@Override
	public List<Voyage> getAllVoyage() {
		
		return voyageRepo.findAll();
	}

	@Override
	public Voyage addVoyage(Voyage voyage) {
		
		return voyageRepo.save(voyage);
	}

	@Override
	public Voyage updateVoyage(Voyage voyage) {
		
		return voyageRepo.save(voyage);
	}

	@Override
	public void deleteVoyage(Voyage voyage) {
		voyageRepo.delete(voyage);

	}

}
