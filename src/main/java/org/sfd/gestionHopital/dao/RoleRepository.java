package org.sfd.gestionHopital.dao;

//import java.util.List;

import org.sfd.gestionHopital.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource
public interface RoleRepository extends JpaRepository<Role,Long>{
        public Role findByLibelle(String roleName);
	
	  
}
