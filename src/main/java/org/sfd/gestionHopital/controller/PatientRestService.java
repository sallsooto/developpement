package org.sfd.gestionHopital.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.sfd.gestionHopital.dao.DossierRepository;
import org.sfd.gestionHopital.dao.PatientRepository;
import org.sfd.gestionHopital.entities.Dossier;
import org.sfd.gestionHopital.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@CrossOrigin("*")
public class PatientRestService {
	 @Autowired
		private PatientRepository patientRepository;
	 @Autowired
	    private DossierRepository dossierRepository; 
	 Dossier dossier=new Dossier();
		 @RequestMapping(value="/ajoutPatient",method=RequestMethod.POST)
		 public Patient ajoutpatient(@RequestBody Patient patient) {
			 return patientRepository.save(patient);
		 }
		 
		 @RequestMapping(value="/ajoutPatient1",method=RequestMethod.POST)
		 public Patient ajoutpatient1(
				   @RequestParam(name="nom")String nom, 
				   @RequestParam(name="prenom")String prenom,
				   @RequestParam(name="lieu")String lieu,
				   @RequestParam(name="email")String email,
				   @RequestParam(name="numeroPiece")String numeroPiece,
				   @RequestParam(name="telephone")String telephone,
				   @RequestParam(name="dateNaissance")String dateNaissance
				                               ) throws ParseException {
			       Patient p=new Patient();
			       DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
			       p.setNom(nom);
			       p.setPrenom(prenom);
			       p.setEmail(email);
			       p.setLieu(lieu);
			       p.setNumeroPiece(numeroPiece);
			       p.setTelephone(telephone);
			       p.setDateNaissance(df.parse(dateNaissance));
			 return patientRepository.save(p);
		 }
		 @RequestMapping(value="/patients",method=RequestMethod.GET)
		 public List<Patient> getpatients(){
			 return patientRepository.findAll();
		 }
	    
		 @RequestMapping(value="/patient/{id}",method=RequestMethod.GET)
		 public Patient getpatient(@PathVariable Long id){
			 return patientRepository.findOne(id);
		 }
		 
		 @RequestMapping(value="/supprimePatient/{id}",method=RequestMethod.DELETE)
		 public boolean supprimepatient(@PathVariable Long id) {
			 patientRepository.delete(id);
			 return true;
		 }
		 
		 @RequestMapping(value="/modifiePatient/{id}",method=RequestMethod.PUT)
		 public Patient modifiepatient(@PathVariable Long id, @RequestBody Patient patient) {
			 patient.setId(id);
			 return patientRepository.save(patient);
		 }
		 
		 @RequestMapping(value="/chercherPatients",method=RequestMethod.GET)
		 public Page<Patient> chercher(
					@RequestParam(name="mc",defaultValue="")String mc,
					@RequestParam(name="page",defaultValue="0")int page, 
					@RequestParam(name="size",defaultValue="5")int size){
				return patientRepository.chercherPatient("%"+mc+"%", new PageRequest(page,size));
			}
		 @RequestMapping(value="/chercherPatientDossier",method=RequestMethod.GET)
		 public Patient chercher(@RequestParam(name="mc")String numeroDossier){
				return patientRepository.trouverPatientByDossier(numeroDossier);
			}
		 @RequestMapping(value="/chercherPatientByNumPiece",method=RequestMethod.GET)
		 public Long chercherPatient(@RequestParam(name="mc")String numPiece){
				return patientRepository.findByNumeroPiece(numPiece).getId();
			}
}
