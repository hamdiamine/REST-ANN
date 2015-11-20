package com.annonces.idao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.annonces.entity.Recherche;

public interface IRechercheDao extends JpaRepository<Recherche, Long>{

	@Query(value="select r.* from ann_recherche r where r.cpt_id = :cpt", nativeQuery=true)
	public List<Recherche> listByCompte(@Param("cpt") Long cpt);
}
