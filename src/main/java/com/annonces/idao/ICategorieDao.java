package com.annonces.idao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.annonces.entity.Categorie;

public interface ICategorieDao extends JpaRepository<Categorie, Long> {

}
