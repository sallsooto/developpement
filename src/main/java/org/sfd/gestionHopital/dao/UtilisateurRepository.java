package org.sfd.gestionHopital.dao;

import org.sfd.gestionHopital.entities.Utilisateur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource
public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long>{
	public Utilisateur findByUsernameAndPassword(String loging,String password);
	public Utilisateur findByUsername(String loging);
	public Utilisateur findById(Long id);
	@Query("select u from Utilisateur u where u.nom like :x")
	public Page<Utilisateur> chercherUtilisateur(@Param("x")String mc, Pageable pageable);
	

	
	
}
