package org.sfd.gestionHopital.controller;

import java.util.List;

import org.sfd.gestionHopital.entities.Medecin;
import org.sfd.gestionHopital.entities.Patient;

public class LesDates {
	private String jour;
	private int jourL;
	private int jourDuMois;
	private int mois;
	private int annee;
	private Medecin medecin;
	private Patient patient;
	private List<String> lesHeures;
	
	public List<String> getLesHeures() {
		return lesHeures;
	}

	public void setLesHeures(List<String> lesHeures) {
		this.lesHeures = lesHeures;
	}
	private Boolean dejaPris;
	
	public Boolean getDejaPris() {
		return dejaPris;
	}

	public void setDejaPris(Boolean dejaPris) {
		this.dejaPris = dejaPris;
	}

	public String getJour() {
		return jour;
	}
	
	public int getJourL() {
		return jourL;
	}

	public void setJourL(int jourL) {
		this.jourL = jourL;
	}

	public Medecin getMedecin() {
		return medecin;
	}

	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public void setJour(int JourC) {
		switch(JourC){
		case 7:this.jour="dimanche";break;
		case 1:this.jour="lundi";break;
		case 2:this.jour="mardi";break;
		case 3:this.jour="mercredi";break;
		case 4:this.jour="jeudi";break;
		case 5:this.jour="vendredi";break;
		case 6:this.jour="samedi";break;
		default:this.jour=null;break;
		}
	}
	public int getJourDuMois() {
		return jourDuMois;
	}
	public void setJourDuMois(int jourDuMois) {
		this.jourDuMois = jourDuMois;
	}
	public int getMois() {
		return mois;
	}
	public void setMois(int mois) {
		this.mois = mois;
	}
	public int getAnnee() {
		return annee;
	}
	public void setAnnee(int annee) {
		this.annee = annee;
	}
	public LesDates() {
		super();
	}
	
	

}
