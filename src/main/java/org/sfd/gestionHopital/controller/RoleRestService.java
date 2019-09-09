package org.sfd.gestionHopital.controller;

import java.util.List;

import org.sfd.gestionHopital.dao.DepartementRepository;
import org.sfd.gestionHopital.dao.RoleRepository;
import org.sfd.gestionHopital.entities.Departement;
import org.sfd.gestionHopital.entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class RoleRestService {

	@Autowired
	 private RoleRepository roleRepository;
	 
	 @RequestMapping(value="/listeRoles",method=RequestMethod.GET)
	 public List<Role> getRoles(){
		 return roleRepository.findAll();
	 }
}
