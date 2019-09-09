package org.sfd.gestionHopital.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Antecedent implements Serializable{
	@Id
	@GeneratedValue
    private Long id;
	private String libelleAntecedent;
	//@ManyToMany
	//@JoinTable(name="AnteDossier")
	public Antecedent(String libelleAntecedent) {
		super();
		this.libelleAntecedent = libelleAntecedent;
	}
	public Antecedent() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLibelleAntecedent() {
		return libelleAntecedent;
	}
	public void setLibelleAntecedent(String libelleAntecedent) {
		this.libelleAntecedent = libelleAntecedent;
	}
	
	
	
	
	
}
