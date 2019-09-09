package org.sfd.gestionHopital.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Specialite implements Serializable {
	@Id
	@GeneratedValue
    private Long id;
	private String libelleSpecialite;
	@JsonManagedReference
	@OneToMany(mappedBy="specialite")
	private Collection<Medecin> medecins;
	
	
	public Specialite(Collection<Medecin> medecins) {
		super();
		this.medecins = medecins;
	}
	public Collection<Medecin> getMedecins() {
		return medecins;
	}
	public void setMedecins(Collection<Medecin> medecins) {
		this.medecins = medecins;
	}
	public Specialite(String libelleSpecialite) {
		super();
		this.libelleSpecialite = libelleSpecialite;
	}
	public Specialite() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLibelleSpecialite() {
		return libelleSpecialite;
	}
	public void setLibelleSpecialite(String libelleSpecialite) {
		this.libelleSpecialite = libelleSpecialite;
	}
}
