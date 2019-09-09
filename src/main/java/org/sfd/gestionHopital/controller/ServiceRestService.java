package org.sfd.gestionHopital.controller;

import java.util.List;

import org.sfd.gestionHopital.dao.DepartementRepository;
import org.sfd.gestionHopital.dao.MedecinRepository;
import org.sfd.gestionHopital.dao.ServiceRepository;
import org.sfd.gestionHopital.entities.Departement;
import org.sfd.gestionHopital.entities.Medecin;
import org.sfd.gestionHopital.entities.Service;
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
public class ServiceRestService {
@Autowired
private ServiceRepository serviceRepository;
@Autowired
private MedecinRepository medecinRepository;
@Autowired
DepartementRepository departementRepository;

/*@RequestMapping(value="/ajouterService",method=RequestMethod.POST)
public Service ajoutService(@RequestBody Service s) {
	 return serviceRepository.save(s);
}*/

@RequestMapping(value="/ajouterService",method=RequestMethod.POST)
public Service ajoutService(
		@RequestParam("libelleService") String libelleService,
		@RequestParam("iddep") String dep_id
		) {
	Departement d=departementRepository.findOne(Long.parseLong(dep_id));
	Service s=new Service();
	s.setDepartements(d);
	s.setLibelleService(libelleService);
	 return serviceRepository.save(s);
}

@RequestMapping(value="/listeServices",method=RequestMethod.GET)
public List<Service> getServices(){
	 return serviceRepository.findAll();
}

@RequestMapping(value="/supprimeService/{id}",method=RequestMethod.DELETE)
public boolean supprimeService(@PathVariable Long id) {
	 serviceRepository.delete(id);
	 return true;
}

@RequestMapping(value="/modifieService/{id}",method=RequestMethod.PUT)
public Service modifieServive(@PathVariable Long id, @RequestBody Service service) {
	 service.setId(id);
	 return serviceRepository.save(service);
}

@RequestMapping(value="/chercherService",method=RequestMethod.GET)
public Page<Service> chercher(
			@RequestParam(name="mc",defaultValue="")String mc,
			@RequestParam(name="page",defaultValue="0")int page, 
			@RequestParam(name="size",defaultValue="5")int size){
		return serviceRepository.chercherService("%"+mc+"%", new PageRequest(page,size));
	}

@RequestMapping(value="/chercherServiceDep",method=RequestMethod.GET)
public List<Service> chercherServiceDep(
			@RequestParam(name="mc",defaultValue="")String x
	){
		return serviceRepository.chercherServiceDep(Long.parseLong(x));
	}
@RequestMapping(value="/chercherMedService",method=RequestMethod.GET)
public List<Medecin> chercherMedService(
			@RequestParam(name="mc",defaultValue="")String x
	){
		return medecinRepository.trouverMedecinService(Long.parseLong(x));
	}
}
