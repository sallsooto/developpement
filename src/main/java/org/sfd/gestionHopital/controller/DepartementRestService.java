package org.sfd.gestionHopital.controller;

import java.util.List;

import org.sfd.gestionHopital.dao.DepartementRepository;
import org.sfd.gestionHopital.entities.Departement;
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
public class DepartementRestService {
 @Autowired
 private DepartementRepository departementRepository;
 
 @RequestMapping(value="/departements",method=RequestMethod.GET)
 public List<Departement> getDepartements(){
	 return departementRepository.findAll();
 } 
  
 @RequestMapping(value="/departements/{id}",method=RequestMethod.GET)
 public Departement getDdepartement(@PathVariable Long id) {
	 return departementRepository.findOne(id);
 }
 
 @RequestMapping(value="/ajoutDepartements",method=RequestMethod.POST)
 public Departement ajoutDepartement(@RequestBody Departement departement) {
	 return departementRepository.save(departement);
 }
 
 @RequestMapping(value="/ajoutDepartement",method=RequestMethod.POST)
 public Departement ajoutDepartement1(
		 @RequestParam("libelledep")String libelledep) {
	 Departement departement=new Departement(libelledep);
	 return departementRepository.save(departement);
 }
 
 @RequestMapping(value="/supprimeDepartements/{id}",method=RequestMethod.DELETE)
 public boolean supprimeDepartement(@PathVariable Long id) {
	 departementRepository.delete(id);
	 return true;
 }
 
 @RequestMapping(value="/modifieDepartements",method=RequestMethod.PUT)
 public Departement modifieDepartement(@PathVariable Long id, @RequestBody Departement departement) {
	 departement.setId(id);
	 return departementRepository.save(departement);
 }
 
 @RequestMapping(value="/chercherDepartements",method=RequestMethod.GET)
 public Page<Departement> chercher(
			@RequestParam(name="mc",defaultValue="")String mc,
			@RequestParam(name="page",defaultValue="0")int page, 
			@RequestParam(name="size",defaultValue="5")int size){
		return departementRepository.chercherDepartement("%"+mc+"%", new PageRequest(page,size));
	}
 
}
