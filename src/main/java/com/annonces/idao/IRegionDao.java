package com.annonces.idao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.annonces.entity.Region;
import com.annonces.entity.Ville;

public interface IRegionDao extends JpaRepository<Region, Long> {
	
	@Query(value="select r.* from ann_ville v, ann_region r where v.vil_id = :vil and v.reg_id = r.reg_id", nativeQuery=true)
	public Region getByVille(@Param("vil") Long ville);

}
