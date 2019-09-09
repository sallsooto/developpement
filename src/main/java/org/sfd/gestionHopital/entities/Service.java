package org.sfd.gestionHopital.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Service implements Serializable{
	@Id
	@GeneratedValue
    private Long id;
	@JsonBackReference
	@ManyToOne
	private Departement departements;
	@JsonManagedReference
	@OneToMany(mappedBy="service")
	private Collection<Medecin> medecins;
	
	public Service(String libelleService) {
		super();
		this.libelleService = libelleService;
	}
	public Service() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String libelleService;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLibelleService() {
		return libelleService;
	}
	public void setLibelleService(String libelleService) {
		this.libelleService = libelleService;
	}
	public Service(Collection<Medecin> medecins) {
		super();
		this.medecins = medecins;
	}
	public Collection<Medecin> getMedecins() {
		return medecins;
	}
	public void setMedecins(Collection<Medecin> medecins) {
		this.medecins = medecins;
	}
	public Service(Departement departements) {
		super();
		this.departements = departements;
	}
	public Departement getDepartements() {
		return departements;
	}
	public void setDepartements(Departement departements) {
		this.departements = departements;
	}
	
	
}
