package com.annonces.idao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.annonces.entity.Region;

public interface IRegionDao extends JpaRepository<Region, Long> {

}
