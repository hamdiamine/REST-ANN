package com.annonces.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.annonces.entity.Recherche;
import com.annonces.idao.IRechercheDao;

@RestController
public class RechercheController {

	@Autowired
	private IRechercheDao rechercheDao;
	
	@RequestMapping("/recherche/create")
	public Recherche Create(@RequestBody Recherche recherche){
		return rechercheDao.save(recherche);
	}
	
	@RequestMapping("/recherche/listcpt")
	public List<Recherche> listbyCompte(Long cpt){
		return rechercheDao.listByCompte(cpt);
	}
	
	@RequestMapping("/recherche/get")
	public Recherche get(Long id){
		return rechercheDao.findOne(id);
	}
	
	@RequestMapping("/recherche/delete")
	public boolean delete(Long id){
		rechercheDao.delete(id);
		return true;
	}
	
	@RequestMapping("/recherche/update")
	public Recherche update(@RequestBody Recherche recherche){
		return rechercheDao.saveAndFlush(recherche);
	}
	
}
