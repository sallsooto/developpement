package org.sfd.gestionHopital.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.sfd.gestionHopital.dao.DossierRepository;
import org.sfd.gestionHopital.dao.PatientRepository;
import org.sfd.gestionHopital.entities.Antecedent;
import org.sfd.gestionHopital.entities.Departement;
import org.sfd.gestionHopital.entities.Dossier;
import org.sfd.gestionHopital.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@CrossOrigin("*")
public class DossierRestService {
  @Autowired
  private  DossierRepository dossierRepository;
  @Autowired
  private PatientRepository patientRepository;
  
	@RequestMapping(value="/chercherDossier",method=RequestMethod.GET)
	 public Dossier chercher(@RequestParam(name="mc")String numeroDossier){
			return dossierRepository.findByNumeroDossier(numeroDossier);
		}
	
	@RequestMapping(value="/chercherAntecedents",method=RequestMethod.GET)
	 public List<Antecedent> chercherAntecedent(@RequestParam(name="mc")String numeroDossier){
			return dossierRepository.findAntecedentByDossierP(numeroDossier);
		}
	@RequestMapping(value="/ajoutDossier",method=RequestMethod.POST)
	 public Dossier ajoutDossier(@RequestBody Dossier d) {
		
		  dossierRepository.save(d);
		  d.setNumeroDossier(d.getId()+d.getLibelleDossier()+new Date());
		  return dossierRepository.saveAndFlush(d);
	 }
	@RequestMapping(value="/ajoutDossier1",method=RequestMethod.POST)
	 public Dossier ajoutDossier1(
			 @RequestParam(name="libelleDossier")String libelleDossier,
			 @RequestParam(name="patient")Long patient_id
			 ) throws ParseException {
		
	
		  Dossier d=new Dossier();
		  d.setLibelleDossier(libelleDossier);
		  d.setPatient(patientRepository.findById(patient_id));
		  dossierRepository.save(d);
		  Date date =new Date();
		  @SuppressWarnings("deprecation")
		String date1=date.getDay()+date.getMonth()+date.getYear()+"";
		  d.setNumeroDossier(d.getId()+date1);
		  return dossierRepository.saveAndFlush(d);
	 }
}
