package com.spring.FlixBus.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Table(name="bookings")
public class Prenotazione {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="total_price")
	private double price;
	
	@Column(name="additional_notes", length=300)
	private String notes;
	
	private int bookedSpots;
	
	@Enumerated(EnumType.STRING)
	private BookingState bookingState;
	
	
	
	 @ManyToOne
	    @JoinColumn(name = "user_id", nullable = false)
	    private User user;
	 
	 @ManyToOne
	    @JoinColumn(name = "voyage_id", nullable = false)
	    private Voyage voyage;
	 
	 public Prenotazione() {
		// TODO Auto-generated constructor stub
	}

	public Prenotazione(Integer id, double price, String notes, int bookedSpots, BookingState bookingState, User user,
			Voyage voyage) {
		super();
		this.id = id;
		this.price = price;
		this.notes = notes;
		this.bookedSpots = bookedSpots;
		this.bookingState = bookingState;
		this.user = user;
		this.voyage = voyage;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public int getBookedSpots() {
		return bookedSpots;
	}

	public void setBookedSpots(int bookedSpots) {
		this.bookedSpots = bookedSpots;
	}

	public BookingState getBookingState() {
		return bookingState;
	}

	public void setBookingState(BookingState bookingState) {
		this.bookingState = bookingState;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Voyage getVoyage() {
		return voyage;
	}

	public void setVoyage(Voyage voyage) {
		this.voyage = voyage;
	}
	 
	 
	 
}
