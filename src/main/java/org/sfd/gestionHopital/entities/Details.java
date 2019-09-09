package org.sfd.gestionHopital.entities;

import javax.persistence.Entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Details implements Serializable{
	@Id
	@GeneratedValue
	private Long id;
	private String dosage;
	@ManyToOne
	private Medicament medicaments;
	@ManyToOne
	private Consultation consultations;
	public Details() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Details(String dosage) {
		super();
		this.dosage = dosage;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDosage() {
		return dosage;
	}
	public void setDosage(String dosage) {
		this.dosage = dosage;
	}
	

}
