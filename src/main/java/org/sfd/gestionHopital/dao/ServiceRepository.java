package org.sfd.gestionHopital.dao;

import java.util.List;

import org.sfd.gestionHopital.entities.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource
public interface ServiceRepository extends JpaRepository<Service,Long>{
	Service findById(Long id);
	@Query("select sd from Service sd where sd.departements.id =:x")
	public List<Service> chercherServiceDep(@Param("x")Long dep_id);
	@Query("select s from Service s where s.libelleService like :x")
	public Page<Service> chercherService(@Param("x")String mc, Pageable pageable);
}
