package org.sfd.gestionHopital.dao;

import java.util.List;

import org.sfd.gestionHopital.entities.Medecin;
import org.sfd.gestionHopital.entities.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MedecinRepository extends JpaRepository<Medecin,Long>{

	public List<Medecin> findByService(Service services);
	public Medecin findByUsernameAndPassword(String login,String password);
	public Medecin findByUsername(String login);
	public Medecin findById(Long id);
	@Query("select med from Medecin med where med.service.id=:x")
	public List<Medecin> trouverMedecinService(@Param("x")Long med_id);
}
