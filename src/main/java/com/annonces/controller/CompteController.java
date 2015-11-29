package com.annonces.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.annonces.entity.Compte;
import com.annonces.idao.ICompteDao;

@RestController
public class CompteController {

	@Autowired
	private ICompteDao compteDao;
	
	@RequestMapping("/compte/authentification")
	public Compte authentification(String login, String mdp){
		return compteDao.findByPseudoAndPasswd(login, mdp);
	}
}
