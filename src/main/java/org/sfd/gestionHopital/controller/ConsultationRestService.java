package org.sfd.gestionHopital.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.sfd.gestionHopital.dao.ConsultationRepository;
import org.sfd.gestionHopital.dao.DossierRepository;
import org.sfd.gestionHopital.dao.MedecinRepository;
import org.sfd.gestionHopital.dao.PatientRepository;
import org.sfd.gestionHopital.dao.PaysRepository;
import org.sfd.gestionHopital.dao.RendezVousRepository;
import org.sfd.gestionHopital.entities.Consultation;
import org.sfd.gestionHopital.entities.Departement;
import org.sfd.gestionHopital.entities.Dossier;
import org.sfd.gestionHopital.entities.Medecin;
import org.sfd.gestionHopital.entities.Patient;
import org.sfd.gestionHopital.entities.RendezVous;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class ConsultationRestService {
	@Autowired
	private PatientRepository patientRepository;
	@Autowired
	private MedecinRepository medecinRepository;
	@Autowired
	private ConsultationRepository consultationRepository;
	@Autowired
	private PaysRepository paysRepository;
	@Autowired 
	DossierRepository dossierRepository;
	@Autowired
	private RendezVousRepository rendezVousRepo;
	
	 @RequestMapping(value="/ajoutConsultation",method=RequestMethod.POST)
	 public Consultation ajoutConsultation(
			   @RequestParam(name="medecin")String login, 
			   @RequestParam(name="commentaire")String commentaire,
			   @RequestParam(name="prescription")String prescription,
			   @RequestParam(name="dossier")String numdossier
			                               ) {
		 
		 List <RendezVous> rv=new ArrayList<>();
			rv=rendezVousRepo.chercherParNumDossier(numdossier);
			RendezVous leRv=new RendezVous();
			if(!rv.isEmpty()) {
				leRv=rv.get(0);
				leRv.setEtat(false);
				rendezVousRepo.saveAndFlush(leRv);
			}
		 
		 Dossier d=new Dossier();
		 Patient p=new Patient();
		 Medecin med=new Medecin();
		 d=dossierRepository.findByNumeroDossier(numdossier);
		 System.out.println("le numero du patient est " + numdossier);
		 p=patientRepository.trouverPatientByDossier(numdossier);
		// System.out.println("le numero du patient est " + p.getNom());
		 med=medecinRepository.findByUsername(login);
		 Consultation c= new Consultation();
		 c.setCommentaire(commentaire);
		 c.setDateConsultation(new Date());
		 c.setMedecins(med);
		 c.setPatients(p);
		 c.setPrescription(prescription);
		       return consultationRepository.save(c);
	 }

}
