package com.spring.FlixBus.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.FlixBus.entities.Prenotazione;
import com.spring.FlixBus.repo.PrenotazioneRepo;


@Service
public class PrenotazioneServiceImpl implements PrenotazioneService {
	
	@Autowired
	private PrenotazioneRepo prenotazioneRepo;
	
	
	@Override
	public Optional<Prenotazione> getById(int id) {
		
		return prenotazioneRepo.findById(id); 
	}

	@Override
	public Optional<List<Prenotazione>> getByUserEmail(String email) {
		
		return prenotazioneRepo.findByUserEmail(email);
	}

	@Override
	public List<Prenotazione> getPrenotazioni() {
		
		return prenotazioneRepo.findAll();
	}

	
	@Override
	public Prenotazione addPrenotazione(Prenotazione u) {
		
		return prenotazioneRepo.save(u);
	}

	@Override
	public Prenotazione updatePrenotazione(Prenotazione u) {
		
		 return prenotazioneRepo.save(u);
	}

	@Override
	public void deletePrenotazione(Prenotazione u) {
		
		prenotazioneRepo.delete(u);
	}

}
