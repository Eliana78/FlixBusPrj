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

import com.spring.FlixBus.entities.Category;
import com.spring.FlixBus.entities.Voyage;
import com.spring.FlixBus.service.VoyageService;

@RestController
@RequestMapping("/api")
public class VoyageCtrl {

	
	  @Autowired
	    private VoyageService voyageService;

	    @GetMapping("/voyages/category/{category}")
	    @CrossOrigin
	    public List<Voyage> getVoyageByCategory(@PathVariable Category category) {
	        return voyageService.getVoyageByCategory(category);
	    }

	    @GetMapping("/voyages/id/{id}")
	    @CrossOrigin
	    public ResponseEntity<Voyage> getVoyageById(@PathVariable int id) {
	        Optional<Voyage> voyageOptional = voyageService.getVoyageById(id);

	        if (voyageOptional.isPresent()) {
	            return ResponseEntity.ok(voyageOptional.get());
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @GetMapping("/voyages/topSix")
	    @CrossOrigin
	    public List<Voyage> getFirstSixVoyage() {
	        return voyageService.getFirstSixVoyage();
	    }

	    @GetMapping("/voyages")
	    @CrossOrigin
	    public List<Voyage> getAllVoyage() {
	        return voyageService.getAllVoyage();
	    }

	    @PostMapping("/voyages/add")
	    @CrossOrigin
	    public Voyage addVoyage(@RequestBody Voyage voyage) {
	        return voyageService.addVoyage(voyage);
	    }

	    @PutMapping("/voyages/update")
	    @CrossOrigin
	    public Voyage updateVoyage(@RequestBody Voyage voyage) {
	        return voyageService.updateVoyage(voyage);
	    }

	    @DeleteMapping("/voyages/delete")
	    @CrossOrigin
	    public void deleteVoyage(@RequestBody Voyage voyage) {
	        voyageService.deleteVoyage(voyage);
	    }
}
