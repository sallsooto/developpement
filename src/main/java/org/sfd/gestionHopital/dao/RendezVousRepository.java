package org.sfd.gestionHopital.dao;

import java.util.Date;
import java.util.List;

import org.sfd.gestionHopital.entities.Medecin;
import org.sfd.gestionHopital.entities.Patient;
import org.sfd.gestionHopital.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RendezVousRepository extends JpaRepository<RendezVous, Long>{
  
	public RendezVous findByMedecinAndDateRvAndHeureDbAndEtat(Medecin med,Date dateRv,String hd,Boolean bool);
	public RendezVous findByPatientAndDateRv(Patient patient,Date dateRv);
	@Query("select rv from RendezVous rv where rv.patient.dossier.numeroDossier =:x and rv.etat =true order by rv.id desc")
	public List<RendezVous> chercherParNumDossier(@Param("x")String numDossier);
	
	@Query("select rv from RendezVous rv where rv.patient.id =:x and rv.medecin.id =:y and rv.etat =true")
	public List<RendezVous> trouverParMedEtPatient(@Param("x")Long p,@Param("y")Long m);
}
