package com.annonces.idao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.annonces.entity.Ville;

public interface IVilleDao extends JpaRepository<Ville, Long> {

}
