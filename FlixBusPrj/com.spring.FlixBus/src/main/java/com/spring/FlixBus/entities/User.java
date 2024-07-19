package com.spring.FlixBus.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable=false)
	private String Name;
	
	private String Surname;
	
	@Column(name="user_email", nullable=false, unique=true)
	private String email;
	
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Prenotazione> prenotazioni;


	public Integer getId() {
	
		return id;
	}
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(Integer id, String name, String surname, String email, String phoneNumber,
			List<Prenotazione> prenotazioni) {
		super();
		this.id = id;
		Name = name;
		Surname = surname;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.prenotazioni = prenotazioni;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getSurname() {
		return Surname;
	}

	public void setSurname(String surname) {
		Surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<Prenotazione> getPrenotazioni() {
		return prenotazioni;
	}

	public void setPrenotazioni(List<Prenotazione> prenotazioni) {
		this.prenotazioni = prenotazioni;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
	
}
