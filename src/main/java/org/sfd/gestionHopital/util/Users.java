package org.sfd.gestionHopital.util;

public class Users {
	   private Long id;	
	   private String nom;
	   private String login;
	   private String password;
	   private String Role;
	   private Boolean Etat;
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Users(Long id, String nom, String login, String password, String role, Boolean etat) {
		super();
		this.id = id;
		this.nom = nom;
		this.login = login;
		this.password = password;
		Role = role;
		Etat = etat;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
	public Boolean getEtat() {
		return Etat;
	}
	public void setEtat(Boolean etat) {
		Etat = etat;
	}
	   
	   
}
