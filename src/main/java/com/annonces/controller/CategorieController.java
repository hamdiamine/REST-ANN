package com.annonces.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.annonces.entity.Categorie;
import com.annonces.idao.ICategorieDao;

@RestController
public class CategorieController {

	@Autowired
	private ICategorieDao categorieDao;
	
	@RequestMapping("/categorie/all")
	public List<Categorie> all(){
		return categorieDao.findAll(new Sort(Sort.Direction.ASC, "label"));
	}
}
