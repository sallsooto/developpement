package org.sfd.gestionHopital.dao;

import org.sfd.gestionHopital.entities.Departement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DepartementRepository extends JpaRepository<Departement,Long>{
    @Query("select d from Departement d where d.libelledep like :x")
	public Page<Departement> chercherDepartement(@Param("x")String mc, Pageable pageable);
}
