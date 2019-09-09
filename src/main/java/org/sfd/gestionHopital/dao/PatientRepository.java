package org.sfd.gestionHopital.dao;

import org.sfd.gestionHopital.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PatientRepository extends JpaRepository<Patient,Long>{

	public Patient findByNumeroPiece(String numPiece);
	public Patient findById(Long id);
	
	@Query("select p from Patient p where p.nom like :x")
	public Page<Patient> chercherPatient(@Param("x")String mc, Pageable pageable);
	@Query("select p from Patient p where p.dossier.numeroDossier like :x")
	public Patient trouverPatientByDossier(@Param("x")String numeroDossier);
	
}
