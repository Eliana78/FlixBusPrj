package com.spring.FlixBus.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.FlixBus.entities.Prenotazione;


@Repository
public interface PrenotazioneRepo extends JpaRepository<Prenotazione, Integer> {

	Optional<Prenotazione> findById(int id);
	
	Optional<List<Prenotazione>> findByUserEmail(String email);

}
