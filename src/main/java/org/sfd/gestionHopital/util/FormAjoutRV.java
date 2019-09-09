package org.sfd.gestionHopital.util;

import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;


public class FormAjoutRV {
	@NotEmpty
	@Size(min=10,max=20)
	private String patientNumPiece;
	@NotEmpty
	private String patientNomComplet;
	private String patientAdresse;
	private  String patientNationalite;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date patientNaissance;
	private String patientTel;
	private Long serviceId;
	private Long medecinId;
	private String dateRV;
	public FormAjoutRV() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FormAjoutRV(@NotEmpty @Size(min = 10, max = 20) String patientNumPiece,@NotEmpty String patientNomComplet, String patientAdresse,
			String patientNationalite, Date patientNaissance, String patientTel, Long serviceId, Long medecinId,
			String dateRV) {
		super();
		this.patientNumPiece = patientNumPiece;
		this.patientNomComplet = patientNomComplet;
		this.patientAdresse = patientAdresse;
		this.patientNationalite = patientNationalite;
		this.patientNaissance = patientNaissance;
		this.patientTel = patientTel;
		this.serviceId = serviceId;
		this.medecinId = medecinId;
		this.dateRV = dateRV;
	}
	public String getPatientNumPiece() {
		return patientNumPiece;
	}
	public void setPatientNumPiece(String patientNumPiece) {
		this.patientNumPiece = patientNumPiece;
	}
	public String getPatientNomComplet() {
		return patientNomComplet;
	}
	public void setPatientNomComplet(String patientNomComplet) {
		this.patientNomComplet = patientNomComplet;
	}
	public String getPatientAdresse() {
		return patientAdresse;
	}
	public void setPatientAdresse(String patientAdresse) {
		this.patientAdresse = patientAdresse;
	}
	public String getPatientNationalite() {
		return patientNationalite;
	}
	public void setPatientNationalite(String patientNationalite) {
		this.patientNationalite = patientNationalite;
	}
	public Date getPatientNaissance() {
		return patientNaissance;
	}
	public void setPatientNaissance(Date patientNaissance) {
		this.patientNaissance = patientNaissance;
	}
	public String getPatientTel() {
		return patientTel;
	}
	public void setPatientTel(String patientTel) {
		this.patientTel = patientTel;
	}
	public Long getServiceId() {
		return serviceId;
	}
	public void setServiceId(Long serviceId) {
		this.serviceId = serviceId;
	}
	public Long getMedecinId() {
		return medecinId;
	}
	public void setMedecinId(Long medecinId) {
		this.medecinId = medecinId;
	}
	public String getDateRV() {
		return dateRV;
	}
	public void setDateRV(String dateRV) {
		this.dateRV = dateRV;
	}
	
	
}
