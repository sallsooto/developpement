package org.sfd.gestionHopital.entities;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;



import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
public class RendezVous {
 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Temporal(TemporalType.DATE)
	private Date dateRv;
	@Column(nullable=false)
	@Size(min=5,max=10)
	private String heureDb;
	@Column(nullable=false)
	private boolean etat;
	@ManyToOne
	@JsonManagedReference
	private Patient patient;
	@ManyToOne
	@JsonManagedReference
	private Service service;
	@ManyToOne
	@JsonManagedReference
	private Medecin medecin;
	
	public RendezVous() {
		super();
	}
	
	public RendezVous(long id, @Size(min = 5, max = 10) Date dateRv, @Size(min = 5, max = 10) String heureDb,
			@Size(min = 1, max = 1) boolean etat, Patient patient, Service service, Medecin medecin) {
		super();
		this.id = id;
		this.dateRv = dateRv;
		this.heureDb = heureDb;
		this.etat = etat;
		this.patient = patient;
		this.service = service;
		this.medecin = medecin;
	}

	

	public RendezVous(@Size(min = 5, max = 10) Date dateRv,  
			Medecin medecin,Service service,@Size(min = 1, max = 1) boolean etat) {
		super();
		this.dateRv = dateRv;
		this.etat = etat;
		this.service = service;
		this.medecin = medecin;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDateRv() {
		return dateRv;
	}

	public void setDateRv(Date dateRv) {
		this.dateRv = dateRv;
	}

	public String getHeureDb() {
		return heureDb;
	}

	public void setHeureDB(String heureDb) {
		this.heureDb = heureDb;
	}

	public boolean isEtat() {
		return etat;
	}

	public void setEtat(boolean etat) {
		this.etat = etat;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public Medecin getMedecin() {
		return medecin;
	}

	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}
	
	
	
	
	
	
	
	
}
