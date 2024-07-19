package com.spring.FlixBus.entities;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



//@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Table(name="voyages")
public class Voyage {

	
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Integer id;
		
		@Column(name="departure", nullable=false)
		private String DepartureLocation;
		
		@Column(name="arrival", nullable=false)
		private String ArrivalLocation;
		
		
		@Column(name="date_departure", nullable=false, updatable=true)
		private LocalDate dateBooked;
		
		@Column(name="available_spots")
		private int availableSpots;
		
		@Column(name="description", length=100)
		private String description;
		
		@Enumerated(EnumType.STRING)
		private Category category;
	
		   @OneToMany(mappedBy = "voyage", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
		    @JsonIgnore
		    private List<Prenotazione> prenotazioni;
		   
		   public Voyage() {
			// TODO Auto-generated constructor stub
		}

		public Voyage(Integer id, String departureLocation, String arrivalLocation, LocalDate dateBooked,
				int availableSpots, String description, Category category, List<Prenotazione> prenotazioni) {
			super();
			this.id = id;
			DepartureLocation = departureLocation;
			ArrivalLocation = arrivalLocation;
			this.dateBooked = dateBooked;
			this.availableSpots = availableSpots;
			this.description = description;
			this.category = category;
			this.prenotazioni = prenotazioni;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getDepartureLocation() {
			return DepartureLocation;
		}

		public void setDepartureLocation(String departureLocation) {
			DepartureLocation = departureLocation;
		}

		public String getArrivalLocation() {
			return ArrivalLocation;
		}

		public void setArrivalLocation(String arrivalLocation) {
			ArrivalLocation = arrivalLocation;
		}

		public LocalDate getDateBooked() {
			return dateBooked;
		}

		public void setDateBooked(LocalDate dateBooked) {
			this.dateBooked = dateBooked;
		}

		public int getAvailableSpots() {
			return availableSpots;
		}

		public void setAvailableSpots(int availableSpots) {
			this.availableSpots = availableSpots;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Category getCategory() {
			return category;
		}

		public void setCategory(Category category) {
			this.category = category;
		}

		public List<Prenotazione> getPrenotazioni() {
			return prenotazioni;
		}

		public void setPrenotazioni(List<Prenotazione> prenotazioni) {
			this.prenotazioni = prenotazioni;
		}
		   
		   
	
}
