package com.annonces.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.annonces.entity.Annonce;
import com.annonces.entity.Photo;
import com.annonces.idao.IPhotoDao;

@RestController
public class PhotoController {

	@Autowired
	private IPhotoDao photoDao;
	
	@RequestMapping("/photo/allByAnn")
	public List<Photo> listByAnnonce(Long annonce){
		return photoDao.findByAnnonce(new Annonce(annonce));
	}
	
	@RequestMapping("/photo/delete")
	public Boolean delete(Long id){
		photoDao.delete(id);
		return true;
	}
	
	@RequestMapping("/photo/create")
	public Photo create(Photo photo){
		return photoDao.save(photo);
	}
	
	@RequestMapping("/photo/deletebyann")
	public Boolean deleteByAnn(Long annonce){
		photoDao.deleteByAnnonce(new Annonce(annonce));
		return true;
	}
}
