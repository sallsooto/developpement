
package org.sfd.gestionHopital.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.sfd.gestionHopital.dao.MedecinRepository;
import org.sfd.gestionHopital.dao.RoleRepository;
import org.sfd.gestionHopital.dao.ServiceRepository;
import org.sfd.gestionHopital.dao.SpecialiteRepository;
import org.sfd.gestionHopital.dao.UtilisateurRepository;
import org.sfd.gestionHopital.entities.Medecin;
import org.sfd.gestionHopital.entities.Role;
import org.sfd.gestionHopital.entities.Specialite;
import org.sfd.gestionHopital.entities.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	private UtilisateurRepository utilisateurRepository;

	@Autowired
	private MedecinRepository medecinRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private ServiceRepository serviceRepository;
	@Autowired
	private SpecialiteRepository specialiteRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public Utilisateur saveUser(String nom, String prenom, Date dateNaissance, String lieu, String email,
			String telephone, String photo, String username, String password, String confirmedPassword,
			String matricule,String specialite, String service) {
		Utilisateur user = utilisateurRepository.findByUsername(username);
		if (user != null)
			throw new RuntimeException("User already exists");
		if (!password.equals(confirmedPassword))
			throw new RuntimeException("Please confirm your password");
		Utilisateur u = new Utilisateur();
		u.setNom(nom);
		u.setPrenom(prenom);
		u.setDateNaissance(new Date());
		u.setLieu(lieu);
		u.setEmail(email);
		u.setTelephone(telephone);
		u.setPhoto(photo);
		u.setUsername(username);
		u.setPassword(bCryptPasswordEncoder.encode(password));
		u.setEnabled(true);
		if(service!=null)
		{
			Medecin med=new Medecin();
			med.setNom(nom);
			med.setPrenom(prenom);
			med.setDateNaissance(dateNaissance);
			med.setLieu(lieu);
			med.setEmail(email);
			med.setTelephone(telephone);
			med.setPhoto(photo);
			med.setUsername(username);
			med.setPassword(bCryptPasswordEncoder.encode(password));
			med.setEnabled(true);

			med.setSpecialite(specialiteRepository.findById(Long.parseLong(specialite)));
			med.setService(serviceRepository.findById(Long.parseLong(service)));
			medecinRepository.save(med);
			String mat=med.getService().getDepartements().getLibelledep().toUpperCase().substring(0, 3)
					+med.getService().getLibelleService().toUpperCase().substring(0, 2)
					+med.getId();
			med.setMatricule(mat);
			medecinRepository.saveAndFlush(med);
			addRoleToUser(username, "USER");
			addRoleToUser(username, "MEDECIN");
			return med;
		}
		else
		{
			utilisateurRepository.save(u);
			addRoleToUser(username, "USER");
			return u;
		}
		
		
	}

	@Override
	public Utilisateur loadUserByLoging(String username) {
		Utilisateur u=utilisateurRepository.findByUsername(username);
		if(u!=null) {
			if(u.getEnabled()) return u;
			else return null;
		}
		return null;
	}

	@Override
	public void addRoleToUser(String username, String rolename) {
		try {
			Utilisateur u = utilisateurRepository.findByUsername(username);
			Role r = roleRepository.findByLibelle(rolename);
			Collection<Role> lesRoles;
			lesRoles=u.getRoles();
			lesRoles.add(r);
			u.setRoles(lesRoles);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		

	}

	@Override
	public Role saveRole(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public Utilisateur saveUser1(String username, String password, String confirmedPassword) {
		Utilisateur  user=utilisateurRepository.findByUsername(username);
        if(user!=null) throw new RuntimeException("User already exists");
        if(!password.equals(confirmedPassword)) throw new RuntimeException("Please confirm your password");
        Utilisateur appUser=new Utilisateur();
        appUser.setUsername(username);
        appUser.setEnabled(true);
        appUser.setPassword(bCryptPasswordEncoder.encode(password));
        utilisateurRepository.save(appUser);
        addRoleToUser(username,"USER");
        return appUser;
	}

	@Override
	public Utilisateur updateUser(Long id, String nom, String prenom, Date dateNaissance, String lieu, String email,
			String telephone, String photo, String username, String password, String confirmedPassword,
			String matricule, String specialite, String service,Boolean enabled) {
		if (service!=null) {
			Medecin med=medecinRepository.findById(id);
			med.setUsername(username);
			med.setNom(nom);
			med.setPrenom(prenom);
			med.setDateNaissance(dateNaissance);
			med.setLieu(lieu);
			med.setEmail(email);
			med.setMatricule(matricule);
			med.setPassword(bCryptPasswordEncoder.encode(password));
			med.setSpecialite(specialiteRepository.findById(Long.parseLong(specialite)));
			med.setService(serviceRepository.findById(Long.parseLong(service)));
			med.setEnabled(enabled);
			medecinRepository.saveAndFlush(med);
			return med;
		}
		else {
			Utilisateur u=utilisateurRepository.findById(id);
			u.setNom(nom);
			u.setPrenom(prenom);
			u.setDateNaissance(dateNaissance);
			u.setLieu(lieu);
			u.setEmail(email);
			u.setTelephone(telephone);
			u.setPhoto(photo);
			u.setUsername(username);
			u.setEnabled(enabled);
			if(password!=null&&u.getPassword()!=password)
			u.setPassword(bCryptPasswordEncoder.encode(password));
			utilisateurRepository.saveAndFlush(u);
			return u;
		}
	}

}
