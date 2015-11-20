package com.annonces.idao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.annonces.entity.Compte;

public interface ICompteDao extends JpaRepository<Compte, Long> {

	public Compte findByPseudoAndPasswd(String login, String passwd);
}
