package org.sfd.gestionHopital.entities;

import javax.persistence.*;

@Entity
public class Parametrage {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(nullable=false)
	private int duree;
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	

}
