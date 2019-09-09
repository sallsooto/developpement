package org.sfd.gestionHopital.dao;

import java.util.List;

import org.sfd.gestionHopital.entities.Antecedent;
import org.sfd.gestionHopital.entities.Dossier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface DossierRepository extends JpaRepository<Dossier,Long>{
 public Dossier findByNumeroDossier(String numDossier);
 @Query("select a.antecedents_id from AnteDossier a where a.dossiers_id.numeroDossier like:x")
 public List<Antecedent> findAntecedentByDossierP(@Param("x")String numDossier); 
}
