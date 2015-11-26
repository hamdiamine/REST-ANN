package com.annonces.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.annonces.entity.Region;
import com.annonces.entity.Ville;
import com.annonces.idao.IRegionDao;

@RestController
public class RegionController {

	@Autowired
	private IRegionDao regionDao;
	
	@RequestMapping("/region/all")
	public List<Region> all(){
		return regionDao.findAll(new Sort(Sort.Direction.ASC, "label"));
	}
	
	@RequestMapping("/region/getbyville")
	public Region getbyville(Long idVil){
		return regionDao.getByVille(idVil);
	}
}
