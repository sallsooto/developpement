package org.sfd.gestionHopital.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
public class Role implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 50)
	private String libelle;
	//@ManyToMany( mappedBy = "roles" , cascade = CascadeType.DETACH)
	//private Collection<Utilisateur> utilisateurs;
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	//, Collection<Utilisateur> utilisateurs
	public Role(String libelle) {
		super();
		this.libelle = libelle;
		//this.utilisateurs = utilisateurs;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/* @JsonIgnore */
	/*
	 * public Collection<Utilisateur> getUtilisateurs() { return utilisateurs; }
	 * public void setUtilisateurs(Collection<Utilisateur> utilisateurs) {
	 * this.utilisateurs = utilisateurs; }
	 */
	
	
	
    
}
