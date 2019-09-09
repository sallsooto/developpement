package org.sfd.gestionHopital.dao;



import org.sfd.gestionHopital.entities.Parametrage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParametrageRepository extends JpaRepository<Parametrage, Long> {
	public Parametrage findById(long id);

}
