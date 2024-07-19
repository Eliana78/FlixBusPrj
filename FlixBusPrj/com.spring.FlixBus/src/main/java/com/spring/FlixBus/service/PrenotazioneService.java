package com.spring.FlixBus.service;

import java.util.List;
import java.util.Optional;

import com.spring.FlixBus.entities.Prenotazione;
import com.spring.FlixBus.entities.User;

public interface PrenotazioneService {

	Optional<Prenotazione> getById(int id);
	
	Optional<List<Prenotazione>> getByUserEmail(String email);
	
	List<Prenotazione> getPrenotazioni();
	Prenotazione addPrenotazione(Prenotazione u);
	Prenotazione updatePrenotazione(Prenotazione u);
	

	void deletePrenotazione(Prenotazione u);
	
	
	
}
