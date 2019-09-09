package org.sfd.gestionHopital.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Pays implements Serializable{
 @Id
 @GeneratedValue
 private Long id;
 private String libellePays;
 @OneToMany(mappedBy="pays")
 private Collection<Patient> patients;
 
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getLibellePays() {
	return libellePays;
}
public void setLibellePays(String libellePays) {
	this.libellePays = libellePays;
}
public Pays() {
	super();
	// TODO Auto-generated constructor stub
}
public Pays(String libellePays) {
	super();
	this.libellePays = libellePays;
}
}
