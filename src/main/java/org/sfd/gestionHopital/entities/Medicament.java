package org.sfd.gestionHopital.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Medicament implements Serializable{
	@Id
	@GeneratedValue
    private Long id;
	private String libellemedi;
	@OneToMany(mappedBy="medicaments")
	private Collection<Details> details;
	

	
	public Medicament(String libellemedi) {
		super();
		this.libellemedi = libellemedi;
	}
	public Medicament() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLibellemedi() {
		return libellemedi;
	}
	public void setLibellemedi(String libellemedi) {
		this.libellemedi = libellemedi;
	}
	
	
}
