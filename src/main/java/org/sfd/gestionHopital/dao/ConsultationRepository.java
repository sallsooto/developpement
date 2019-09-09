package org.sfd.gestionHopital.dao;

import java.util.List;

import org.sfd.gestionHopital.entities.Consultation;
import org.sfd.gestionHopital.entities.Medecin;
import org.sfd.gestionHopital.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {

	
	  public List<Consultation> findByMedecins(Medecin med);
	  public List<Consultation> findByPatients(Patient pat);
	  
	  
	  @Query("select c.dateConsultation,c.prescription,c.commentaire,"
	  		+ "c.patients.nom,c.patients.prenom,c.patients.dateNaissance "
	  		+ "from Consultation c where c.medecins.matricule like :x order by c.dateConsultation desc") 
	  public  Page<Consultation> chercherConsultationByMatMedecin(@Param("x")String matriculeMed, Pageable pageable);
	  
	  
	  @Query("select c.dateConsultation,c.prescription,"
	  		+ "c.commentaire,c.patients.nom,c.patients.prenom,"
	  		+ "c.patients.dateNaissance from Consultation c where"
	  		+ " c.patients.dossier.numeroDossier like :x order by c.dateConsultation desc")
	  public Page<Consultation> chercherConsultationByDossierPatient(@Param("x")String numeroDossier, Pageable pageable);
	 
}
