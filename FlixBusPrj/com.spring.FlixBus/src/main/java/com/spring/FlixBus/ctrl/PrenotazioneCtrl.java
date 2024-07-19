package com.spring.FlixBus.ctrl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.spring.FlixBus.entities.Prenotazione;
import com.spring.FlixBus.service.PrenotazioneService;

@RestController
@RequestMapping("/api")
public class PrenotazioneCtrl {

	@Autowired
	private PrenotazioneService prontazioneService;
	
	
	@GetMapping("/prenotazioni/id/{id}")
	@CrossOrigin
	public ResponseEntity<Prenotazione> getById(@PathVariable int id){
		 Optional<Prenotazione> prenotazioneOptional = prontazioneService.getById(id);
	        
	        if (prenotazioneOptional.isPresent()) {
	            return ResponseEntity.ok(prenotazioneOptional.get());
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	}
		 
	
	
	
	 @GetMapping("/prenotazioni/email/{email}")
	    @CrossOrigin
	    public ResponseEntity<Optional<List<Prenotazione>>> getByUserEmail(@PathVariable String email) {
	        Optional<List<Prenotazione>> prenotazioniOptional = prontazioneService.getByUserEmail(email);
	        
	        if (prenotazioniOptional.isPresent()) {
	            return ResponseEntity.ok(prenotazioniOptional);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	

	@GetMapping("/prenotazioni")
	@CrossOrigin
	public List<Prenotazione> getPrenotazioni(){
		return prontazioneService.getPrenotazioni();
		
	}
	
	
	
	
	@PostMapping ("/prenotazioni/add")
	@CrossOrigin
	public Prenotazione addPrenotazione(@RequestBody Prenotazione u) {
		return prontazioneService.addPrenotazione(u);
	}
	
	@PutMapping ("/prenotazioni/update")
	@CrossOrigin
	public Prenotazione updatePrenotazione(@RequestBody Prenotazione u) {
		return prontazioneService.updatePrenotazione(u);
		
	}
	
	
	
	@DeleteMapping("/delete/prenotazione/{u}")
	public void deletePrenotazione(@PathVariable Prenotazione u) {
		prontazioneService.deletePrenotazione(u);
	}
	
	
}
