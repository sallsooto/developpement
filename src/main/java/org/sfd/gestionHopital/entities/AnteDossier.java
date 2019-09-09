package org.sfd.gestionHopital.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class AnteDossier implements Serializable {
	@Id
	@GeneratedValue
	private Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@ManyToOne
	private Antecedent antecedents_id;
	@ManyToOne
	private Dossier 	dossiers_id;
	public Antecedent getAntecedents_id() {
		return antecedents_id;
	}
	public void setAntecedents_id(Antecedent antecedents_id) {
		this.antecedents_id = antecedents_id;
	}
	public Dossier getDossiers_id() {
		return dossiers_id;
	}
	public void setDossiers_id(Dossier dossiers_id) {
		this.dossiers_id = dossiers_id;
	}
	public AnteDossier(Antecedent antecedents_id, Dossier dossiers_id) {
		super();
		this.antecedents_id = antecedents_id;
		this.dossiers_id = dossiers_id;
	}
	public AnteDossier() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
