package org.sfd.gestionHopital.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Medecin  extends Utilisateur implements Serializable {
	@Id
	@GeneratedValue
    private Long id;
	private String matricule;
	@JsonBackReference
	@ManyToOne
	private Specialite specialite;
	@JsonBackReference
	@ManyToOne
	private Service service;
	@JsonManagedReference
	@OneToMany(mappedBy="medecins")
	private Collection<Consultation> consultations;
	
	
	public Medecin(Specialite specialite) {
		super();
		this.specialite = specialite;
	}
	public Specialite getSpecialite() {
		return specialite;
	}
	public void setSpecialite(Specialite specialite) {
		this.specialite = specialite;
	}
	public Medecin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Medecin(String nom, String prenom, Date dateNaissance, String lieu, String email, String telephone,
			String photo, String loging, String password, Boolean enabled, Collection<Role> roles) {
		super(nom, prenom, dateNaissance, lieu, email, telephone, photo, loging, password, enabled, roles);
		// TODO Auto-generated constructor stub
	}
	public Medecin(String matricule) {
		super();
		this.matricule = matricule;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public Medecin(Service service) {
		super();
		this.service = service;
	}
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}
	public Collection<Consultation> getConsultations() {
		return consultations;
	}
	public void setConsultations(Collection<Consultation> consultations) {
		this.consultations = consultations;
	}

    
}
