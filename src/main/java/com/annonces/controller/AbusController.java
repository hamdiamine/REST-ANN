package com.annonces.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.annonces.entity.Abus;
import com.annonces.idao.IAbusDao;

@RestController
public class AbusController {
	
	@Autowired
	private IAbusDao abusDao;

	@RequestMapping("/abus/create")
	public Abus create(@RequestBody Abus abus) {
		return abusDao.save(abus);
	}
}
