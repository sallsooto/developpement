package org.sfd.gestionHopital.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Parametres {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable=false)
	private int dureeConsultation;
	public Parametres() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Parametres(long id, int dureeConsultation) {
		super();
		this.id = id;
		this.dureeConsultation = dureeConsultation;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getDureeConsultation() {
		return dureeConsultation;
	}
	public void setDureeConsultation(int dureeConsultation) {
		this.dureeConsultation = dureeConsultation;
	}	

	
}
