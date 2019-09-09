package org.sfd.gestionHopital.controller;

import org.sfd.gestionHopital.dao.ConsultationRepository;
import org.sfd.gestionHopital.entities.Consultation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class MedecinRestService {
	@Autowired
	private ConsultationRepository consultationRepository;
	 @RequestMapping(value="/chercherConsultationsMed",method=RequestMethod.GET)
	 public Page<Consultation> chercher(
				@RequestParam(name="mc",defaultValue="")String mc,
				@RequestParam(name="page",defaultValue="0")int page, 
				@RequestParam(name="size",defaultValue="5")int size){
			return consultationRepository.chercherConsultationByMatMedecin("%"+mc+"%", new PageRequest(page,size));
		}
	 
	 @RequestMapping(value="/chercherConsultationsDossier",method=RequestMethod.GET)
	 public Page<Consultation> chercher1(
				@RequestParam(name="mc",defaultValue="")String mc,
				@RequestParam(name="page",defaultValue="0")int page, 
				@RequestParam(name="size",defaultValue="5")int size){
			return consultationRepository.chercherConsultationByDossierPatient("%"+mc+"%", new PageRequest(page,size));
		}
}
