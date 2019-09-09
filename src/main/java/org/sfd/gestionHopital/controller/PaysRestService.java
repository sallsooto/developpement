package org.sfd.gestionHopital.controller;

import java.util.List;

import org.sfd.gestionHopital.dao.PaysRepository;
import org.sfd.gestionHopital.entities.Pays;
import org.sfd.gestionHopital.entities.Service;
import org.sfd.gestionHopital.entities.Utilisateur;
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
public class PaysRestService {
@Autowired
private PaysRepository paysRepository;

@RequestMapping(value="/ajouterPays",method=RequestMethod.POST)
public Pays ajoutService(@RequestBody Pays p) {
	 return paysRepository.save(p);
}

@RequestMapping(value="/listePays",method=RequestMethod.GET)
public List<Pays> getPays(){
	 return paysRepository.findAll();
}

@RequestMapping(value="/supprimePays/{id}",method=RequestMethod.DELETE)
public boolean supprimePays(@PathVariable Long id) {
	 paysRepository.delete(id);
	 return true;
}

@RequestMapping(value="/modifiePays/{id}",method=RequestMethod.PUT)
public Pays modifiePays(@PathVariable Long id, @RequestBody Pays pays) {
	 pays.setId(id);
	 return paysRepository.save(pays);
}

@RequestMapping(value="/chercherPays",method=RequestMethod.GET)
public Page<Pays> chercher(
			@RequestParam(name="mc",defaultValue="")String mc,
			@RequestParam(name="page",defaultValue="0")int page, 
			@RequestParam(name="size",defaultValue="5")int size){
		return paysRepository.chercherPays("%"+mc+"%", new PageRequest(page,size));
	}
	
}
