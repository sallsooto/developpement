package org.sfd.gestionHopital.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Dossier implements Serializable{
	@Id
	@GeneratedValue
    private Long id;
	private String numeroDossier;
	@JsonBackReference
	@OneToOne
	private Patient patient;
	
	public Dossier(String numeroDossier, String libelleDossier) {
		super();
		this.numeroDossier = numeroDossier;
		this.libelleDossier = libelleDossier;
	}
	public Dossier() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNumeroDossier() {
		return numeroDossier;
	}
	public void setNumeroDossier(String numeroDossier) {
		this.numeroDossier = numeroDossier;
	}
	public String getLibelleDossier() {
		return libelleDossier;
	}
	public void setLibelleDossier(String libelleDossier) {
		this.libelleDossier = libelleDossier;
	}
	private String libelleDossier;

	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Dossier(Patient patient) {
		super();
		this.patient = patient;
	}

	
	
}
