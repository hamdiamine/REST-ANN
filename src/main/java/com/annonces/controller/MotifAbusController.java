package com.annonces.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.annonces.entity.MotifAbus;
import com.annonces.idao.IMotifAbusDao;

@RestController
public class MotifAbusController {

	@Autowired
	private IMotifAbusDao motifAbusDao;
	
	@RequestMapping("/motifabus/all")
	public List<MotifAbus> all() {
		return motifAbusDao.findAll();
	}

}
