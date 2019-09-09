package org.sfd.gestionHopital.dao;

import org.sfd.gestionHopital.entities.Pays;
import org.sfd.gestionHopital.entities.Utilisateur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PaysRepository extends JpaRepository<Pays,Long>{
	@Query("select p from Pays p where p.libellePays like :x")
	public Page<Pays> chercherPays(@Param("x")String mc, Pageable pageable);
}
