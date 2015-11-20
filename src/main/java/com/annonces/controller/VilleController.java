package com.annonces.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.annonces.entity.Ville;
import com.annonces.idao.IVilleDao;

@RestController
public class VilleController {
	
	@Autowired
	private IVilleDao villeDao;
	
	@RequestMapping("/ville/all")
	public List<Ville> all(){
		return villeDao.findAll(new Sort(Sort.Direction.ASC, "label"));
	}

}
