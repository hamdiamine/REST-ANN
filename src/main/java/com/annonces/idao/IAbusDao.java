package com.annonces.idao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.annonces.entity.Abus;

public interface IAbusDao extends JpaRepository<Abus, Long> {

}
