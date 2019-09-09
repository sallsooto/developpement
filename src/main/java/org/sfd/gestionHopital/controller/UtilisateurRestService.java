package org.sfd.gestionHopital.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.sfd.gestionHopital.dao.MedecinRepository;
import org.sfd.gestionHopital.dao.RoleRepository;
import org.sfd.gestionHopital.dao.SpecialiteRepository;
import org.sfd.gestionHopital.dao.UtilisateurRepository;
import org.sfd.gestionHopital.entities.Medecin;
import org.sfd.gestionHopital.entities.Role;
import org.sfd.gestionHopital.entities.Service;
import org.sfd.gestionHopital.entities.Specialite;
import org.sfd.gestionHopital.entities.Utilisateur;
import org.sfd.gestionHopital.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class UtilisateurRestService {
	 @Autowired
	private UtilisateurRepository utilisateurRepository;
	 @Autowired
	 private RoleRepository roleRepository;

	 @Autowired
	 private SpecialiteRepository specialiteRepository;
	  @Autowired 
	  private AccountService accountService;
	  @Autowired 
	  private MedecinRepository medecinRepository;
	 
	/*
	 * @RequestMapping(value="/ajoutUtilisateurs",method=RequestMethod.POST) public
	 * Utilisateur ajoutUtilisateurs(@RequestBody Utilisateur utilisateur) { return
	 * utilisateurRepository.save(utilisateur); }
	 */
	
/*	@RequestMapping(value="/ajoutUtilisateurs",method=RequestMethod.POST)
	public Utilisateur register(@RequestBody UtilisateurForm utilisateurForm) {
		
		return accountService.saveUser(utilisateurForm.getNom(), utilisateurForm.getPrenom(),
				utilisateurForm.getDateNaissance(), utilisateurForm.getLieu(), utilisateurForm.getEmail(),
				utilisateurForm.getTelephone(),utilisateurForm.getPhoto(),utilisateurForm.getUsername(), 
				utilisateurForm.getPassword(), utilisateurForm.getConfirmedPassword());
				
	}*/
	
	@RequestMapping(value="/updateUtilisateurs",method=RequestMethod.POST)
	public Utilisateur update(@RequestBody UtilisateurForm utilisateurForm) {
		
		return accountService.updateUser(utilisateurForm.getId(),utilisateurForm.getNom(), utilisateurForm.getPrenom(),
				utilisateurForm.getDateNaissance(), utilisateurForm.getLieu(), utilisateurForm.getEmail(),
				utilisateurForm.getTelephone(),utilisateurForm.getPhoto(),utilisateurForm.getUsername(), 
				utilisateurForm.getPassword(),
				utilisateurForm.getConfirmedPassword(),utilisateurForm.getMatricule(),
				utilisateurForm.getSpecialite(),utilisateurForm.getService(),utilisateurForm.getEnabled());
				
	}
	
	
	
	@RequestMapping(value="/ajoutUtilisateurs",method=RequestMethod.POST)
	public Utilisateur register(@RequestBody UtilisateurForm utilisateurForm) {
		
		return accountService.saveUser(utilisateurForm.getNom(), utilisateurForm.getPrenom(),
				utilisateurForm.getDateNaissance(), utilisateurForm.getLieu(), utilisateurForm.getEmail(),
				utilisateurForm.getTelephone(),utilisateurForm.getPhoto(),utilisateurForm.getUsername(), 
				utilisateurForm.getPassword(), utilisateurForm.getConfirmedPassword(),utilisateurForm.getMatricule(),utilisateurForm.getSpecialite(),utilisateurForm.getService());
				
	}
	
	
	@RequestMapping(value="/addRoleToUser",method=RequestMethod.POST)
	public void addRoleToUser(
			@RequestParam("username") String username,
			@RequestParam("rolename") String rolename
			)
	{
		try {
			Boolean bool=false;
			Collection<Role> lesRoles=utilisateurRepository.findByUsername(username).getRoles();
			for (Role role : lesRoles) {
				if(rolename.equals(role.getLibelle())) {
					bool=true;
				}
			}
			if(bool==false) {
				accountService.addRoleToUser(username,rolename);
				System.out.println("le role "+rolename+" a été ajouté pour le user "+username);
			}
			
		} catch (Exception e) {
			e.printStackTrace(); 	
		}
		
	}
	
	@RequestMapping(value="/verifieUsername",method=RequestMethod.POST)
	public Boolean userExist(@RequestParam String username)
	{
		Utilisateur user = utilisateurRepository.findByUsername(username);
		if (user != null)
		return true;
		else
			return false;
	}
	
	@RequestMapping(value="/dateNaissanceValide",method=RequestMethod.POST)
	public Boolean dateNaissanceValide(@RequestBody DateValide date)
	{
		
		if (date.getDateNaiss().getYear()+18 <= new Date().getYear()) {
			
			return true;
		}
		
		else {
			return false;
		}
			
	}
	
	@RequestMapping(value="/deleteAllRolesUser",method=RequestMethod.POST)
	public void deleteAllRolesUser(
			@RequestParam("username") String username
			)
	{
		try {
			Utilisateur user=utilisateurRepository.findByUsername(username);
			Collection<Role> lesRoles=utilisateurRepository.findByUsername(username).getRoles();
			lesRoles.clear();
			lesRoles.add(roleRepository.findByLibelle("USER"));
			user.setRoles(lesRoles);
			utilisateurRepository.saveAndFlush(user);
		} catch (Exception e) {
			e.printStackTrace(); 	
		}
		
	}
	 
	 @RequestMapping(value="/utilisateurs",method=RequestMethod.GET)
	 public List<Utilisateur> getUtilisateurs(){
		 return utilisateurRepository.findAll();
	 }
	 
	 @RequestMapping(value="/specialites",method=RequestMethod.GET)
	 public List<Specialite> getSpecialites(){
		 return specialiteRepository.findAll();
	 }
    
	 @RequestMapping(value="/utilisateur/{id}",method=RequestMethod.GET)
	 public Utilisateur getUtilisateur(@PathVariable Long id){
		 return utilisateurRepository.findOne(id);
	 }
	 
	 @RequestMapping(value="/supprimeUtilisateur/{id}",method=RequestMethod.DELETE)
	 public boolean supprimeUtilisateur(@PathVariable Long id) {
		 utilisateurRepository.delete(id);
		 return true;
	 }
	 
	 @RequestMapping(value="/modifieUtilisateur/{id}",method=RequestMethod.PUT)
	 public Utilisateur modifieUtilisateur(@PathVariable Long id, @RequestBody Utilisateur utilisateur) {
		 utilisateur.setId(id);
		 return utilisateurRepository.save(utilisateur);
	 }
	 

	 
	 @RequestMapping(value="/chercherUtilisateurs",method=RequestMethod.GET)
	 public Page<Utilisateur> chercher(
				@RequestParam(name="mc",defaultValue="")String mc,
				@RequestParam(name="page",defaultValue="0")int page, 
				@RequestParam(name="size",defaultValue="5")int size){
			return utilisateurRepository.chercherUtilisateur("%"+mc+"%", new PageRequest(page,size));
		}
	 
	 @RequestMapping(value="/rolesUser",method=RequestMethod.GET)
	 public List<String> rolesUser(
				@RequestParam(name="idUser")String id){
		 List<String> lesRoles=new ArrayList<>();
		Collection<Role> roles=utilisateurRepository.findById(Long.parseLong(id)).getRoles();
		for (Role role : roles) {
			lesRoles.add(role.getLibelle());
		}
			return lesRoles;
		}
	 
	 
		
}
class DateValide{
	private Date dateNaiss;

	public Date getDateNaiss() {
		return dateNaiss;
	}

	public void setDateNaiss(Date dateNaiss) {
		this.dateNaiss = dateNaiss;
	}
	
}
class UtilisateurForm{
	private Long id;
	private String nom;
	private String prenom;
	private Date dateNaissance;
	private String lieu;
	private String email;
	private String telephone;
	private String photo;
	private String username;
    private String password;
    private String confirmedPassword;
    private String matricule;
    private String specialite;
    private String service;
    private Boolean enabled;
    
    
    
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public String getSpecialite() {
		return specialite;
	}
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmedPassword() {
		return confirmedPassword;
	}
	public void setConfirmedPassword(String confirmedPassword) {
		this.confirmedPassword = confirmedPassword;
	}
    
    
}
