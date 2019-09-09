package org.sfd.gestionHopital.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Patient implements Serializable{
	@Id
	@GeneratedValue
	private Long id;
	private String nom;
	private String prenom;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateNaissance;
	private String lieu;
	private String numeroPiece;
	@Email
	private String email;
	private String telephone;
	private String photo;
	@JsonManagedReference
	@OneToOne(mappedBy="patient")
	private Dossier dossier;
	
	
	public Patient(Dossier dossier) {
		super();
		this.dossier = dossier;
	}
	public Dossier getDossier() {
		return dossier;
	}
	public void setDossier(Dossier dossier) {
		this.dossier = dossier;
	}
	@ManyToOne
	private Pays pays;
	@OneToMany(mappedBy="patients")
	private Collection<Consultation> consultations;
	
	public Patient(String nom, String prenom, Date dateNaissance, String lieu, String numeroPiece, String email,
			String telephone, String photo) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.lieu = lieu;
		this.numeroPiece = numeroPiece;
		this.email = email;
		this.telephone = telephone;
		this.photo = photo;
	}
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Patient(Collection<Consultation> consultations) {
		super();
		this.consultations = consultations;
	}
	public Collection<Consultation> getConsultations() {
		return consultations;
	}
	public void setConsultations(Collection<Consultation> consultations) {
		this.consultations = consultations;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	public String getNumeroPiece() {
		return numeroPiece;
	}
	public void setNumeroPiece(String numeroPiece) {
		this.numeroPiece = numeroPiece;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Pays getPays() {
		return pays;
	}
	public void setPays(Pays pays) {
		this.pays = pays;
	}
	public Patient(Pays pays) {
		super();
		this.pays = pays;
	}
	
	
	//private Pays pays;
	
}
