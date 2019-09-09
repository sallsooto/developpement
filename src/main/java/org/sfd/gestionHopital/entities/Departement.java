package org.sfd.gestionHopital.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Departement implements Serializable{
	@Id
	@GeneratedValue
    private Long id;
	@JsonManagedReference
	@OneToMany(mappedBy="departements")
	private Collection<Service> services;
	
	public Departement(String libelledep) {
		super();
		this.libelledep = libelledep;
	}
	public Departement() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String libelledep;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLibelledep() {
		return libelledep;
	}
	public void setLibelledep(String libelledep) {
		this.libelledep = libelledep;
	}
	public Departement(Collection<Service> services) {
		super();
		this.services = services;
	}
	public Collection<Service> getServices() {
		return services;
	}
	public void setServices(Collection<Service> services) {
		this.services = services;
	}
	
	
}
