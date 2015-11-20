package com.annonces.idao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.annonces.entity.Annonce;
import com.annonces.entity.Photo;

public interface IPhotoDao extends JpaRepository<Photo, Long> {
	
	public List<Photo> findByAnnonce(Annonce annonce);
	
	public Long deleteByAnnonce(Annonce annonce);
}
