package org.sfd.gestionHopital.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Consultation implements Serializable{
	@Id
	@GeneratedValue
    private Long id;
	@Temporal(TemporalType.DATE)
	private Date dateConsultation;
	@OneToMany(mappedBy="consultations")
	private Collection<Details> details;
	@JsonBackReference
	@ManyToOne
	private Patient patients;
	@ManyToOne
	@JsonBackReference
	private Medecin medecins;
	public Consultation(Date dateConsultation, String commentaire, String prescription) {
		super();
		this.dateConsultation = dateConsultation;
		this.commentaire = commentaire;
		this.prescription = prescription;
	}
	public Consultation() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String commentaire;
	private String prescription;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDateConsultation() {
		return dateConsultation;
	}
	public void setDateConsultation(Date dateConsultation) {
		this.dateConsultation = dateConsultation;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	public String getPrescription() {
		return prescription;
	}
	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}
	public Patient getPatients() {
		return patients;
	}
	public void setPatients(Patient patients) {
		this.patients = patients;
	}
	public Consultation(Patient patients) {
		super();
		this.patients = patients;
	}
	public Medecin getMedecins() {
		return medecins;
	}
	public void setMedecins(Medecin medecins) {
		this.medecins = medecins;
	}
	
	
	
}
