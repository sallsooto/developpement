package org.sfd.gestionHopital.dao;

import org.sfd.gestionHopital.entities.Parametres;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParametresRepository extends JpaRepository<Parametres, Long>{
	public Parametres findById(long id);
}
