package com.annonces.idao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.annonces.entity.TypeCategorie;

public interface ITypeCategorie extends JpaRepository<TypeCategorie, Long> {

}
