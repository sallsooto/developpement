
package org.sfd.gestionHopital.service;

import java.util.Date;

import org.sfd.gestionHopital.entities.Role;
import org.sfd.gestionHopital.entities.Service;
import org.sfd.gestionHopital.entities.Specialite;
import org.sfd.gestionHopital.entities.Utilisateur;

public interface AccountService {
	public Utilisateur saveUser(String nom, String prenom, Date dateNaissance, String lieu, String email,
			String telephone, String photo, String username, String password, String confirmedPassword,String matricule,String specialite,String service);

	 public Utilisateur saveUser1(String username,String password,String confirmedPassword);
	public Utilisateur loadUserByLoging(String loging);

	public Role saveRole(Role role);

	public void addRoleToUser(String username, String rolename);
	
	public Utilisateur updateUser(Long id,String nom, String prenom, Date dateNaissance, String lieu, String email,
			String telephone, String photo, String username, String password, String confirmedPassword,
			String matricule,String specialite,String service,Boolean enabled);


}
