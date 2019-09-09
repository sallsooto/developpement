package org.sfd.gestionHopital.dao;

import java.util.List;

import org.sfd.gestionHopital.entities.Antecedent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AntecedentRepository extends JpaRepository<Antecedent,Long>{
	/*
	 * @Query("select a from Antecedent a where a.dossiers.numeroDossier=:x") public
	 * List<Antecedent> findByDossiers(@Param("x")String numDossier);
	 */
}
