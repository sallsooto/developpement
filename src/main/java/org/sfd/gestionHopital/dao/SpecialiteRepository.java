package org.sfd.gestionHopital.dao;

import org.sfd.gestionHopital.entities.Specialite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialiteRepository extends JpaRepository<Specialite,Long>{
	public Specialite findById(Long id);
}
