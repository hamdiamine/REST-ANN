package com.annonces.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.annonces.entity.Annonce;
import com.annonces.entity.Categorie;
import com.annonces.entity.Recherche;
import com.annonces.entity.Region;
import com.annonces.entity.Ville;
import com.annonces.idao.IAnnonceDao;
import com.annonces.idao.IPhotoDao;

@RestController
public class AnnonceController {

	@Autowired
	private IAnnonceDao annonceDao;

	@Autowired
	private IPhotoDao photoDao;

	@RequestMapping("/annonce/all")
	public List<Annonce> all() {
		return annonceDao.findAll();
	}

	@RequestMapping("/annonce/allp")
	public Page<Annonce> allP(int page) {
		return annonceDao.findAll(new PageRequest(page, 20));
	}
	
	@RequestMapping("/annonce/findbytype")
	public Page<Annonce> findByType(int type, int page, int sort){
		if (sort == 0) {
			return annonceDao.findByType(type, new PageRequest(page, 20));
		} else if (sort == 1) {
			return annonceDao.findByType(type, new PageRequest(page, 20, Sort.Direction.ASC, "dateDepose"));
		} else if (sort == 2) {
			return annonceDao.findByType(type, new PageRequest(page, 20, Sort.Direction.DESC, "dateDepose"));
		} else if (sort == 3) {
			return annonceDao.findByType(type, new PageRequest(page, 20, Sort.Direction.ASC, "prix"));
		} else if (sort == 4) {
			return annonceDao.findByType(type, new PageRequest(page, 20, Sort.Direction.DESC, "prix"));
		}
		return annonceDao.findByType(type, new PageRequest(page, 20));
	}

	@RequestMapping("/annonce/allofrregp")
	public Page<Annonce> allOfrByRegP(Long reg, int page, int sort) {
		if (sort == 0) {
			return annonceDao.findByRegionAndType(new Region(reg, null, null), 0, new PageRequest(page, 20));
		} else if (sort == 1) {
			return annonceDao.findByRegionAndType(new Region(reg, null, null), 0,
					new PageRequest(page, 20, Sort.Direction.ASC, "dateDepose"));
		} else if (sort == 2) {
			return annonceDao.findByRegionAndType(new Region(reg, null, null), 0,
					new PageRequest(page, 20, Sort.Direction.DESC, "dateDepose"));
		} else if (sort == 3) {
			return annonceDao.findByRegionAndType(new Region(reg, null, null), 0,
					new PageRequest(page, 20, Sort.Direction.ASC, "prix"));
		} else if (sort == 4) {
			return annonceDao.findByRegionAndType(new Region(reg, null, null), 0,
					new PageRequest(page, 20, Sort.Direction.DESC, "prix"));
		}
		return annonceDao.findByRegionAndType(new Region(reg, null, null), 0, new PageRequest(page, 20));
	}

	@RequestMapping("/annonce/researchcrt")
	public Page<Annonce> researchCrit(String mCle, boolean ofr, boolean dem, boolean aDesc, Long reg, Long cat,
			Long vil, boolean part, boolean prof, boolean urg, Integer ray, Float lp, Float lg, int page, int sort) {
		Region rg = null;
		Categorie ct = null;
		Ville vl = null;
		Double lpmin = null;
		Double lpmax = null;
		Double lgmin = null;
		Double lgmax = null;
		if (ray != null) {
			// 1° de latitude = 111,11 Km, on fait donc un produit en croix
			double offSetLat = ray / 111.11;

			// 1° de longitude à 'latitude' degrés de latitude correspond à
			// OneLongitudeDegree mètres. On passe à la méthode Math.Cos
			// des radians
			double oneLongitudeDegree = 111.11 * Math.cos(lp * Math.PI / 180);

			// Produit en croix pour trouver le nombre de degrés de longitude
			// auquel
			// correspond la longueur de notre rayon
			double offSetLong = ray / oneLongitudeDegree;

			lpmax = lp + offSetLat;
			lpmin = lp - offSetLat;
			lgmax = lg + offSetLong;
			lgmin = lg - offSetLong;
		}

		String motCle = "%" + mCle.toUpperCase() + "%";

		if (reg != null) {
			rg = new Region(reg);
		}
		if (cat != null) {
			ct = new Categorie(cat);
		}
		if (vil != null) {
			vl = new Ville(vil);
		}

		if (sort == 0) {
			return annonceDao.researchCrit(motCle, ofr, dem, aDesc, rg, ct, vl, part, prof, urg, lpmin, lpmax, lgmin,
					lgmax, ray, new PageRequest(page, 20));
		} else if (sort == 1) {
			return annonceDao.researchCrit(motCle, ofr, dem, aDesc, rg, ct, vl, part, prof, urg, lpmin, lpmax, lgmin,
					lgmax, ray, new PageRequest(page, 20, Sort.Direction.ASC, "dateDepose"));
		} else if (sort == 2) {
			return annonceDao.researchCrit(motCle, ofr, dem, aDesc, rg, ct, vl, part, prof, urg, lpmin, lpmax, lgmin,
					lgmax, ray, new PageRequest(page, 20, Sort.Direction.DESC, "dateDepose"));
		} else if (sort == 3) {
			return annonceDao.researchCrit(motCle, ofr, dem, aDesc, rg, ct, vl, part, prof, urg, lpmin, lpmax, lgmin,
					lgmax, ray, new PageRequest(page, 20, Sort.Direction.ASC, "prix"));
		} else if (sort == 4) {
			return annonceDao.researchCrit(motCle, ofr, dem, aDesc, rg, ct, vl, part, prof, urg, lpmin, lpmax, lgmin,
					lgmax, ray, new PageRequest(page, 20, Sort.Direction.DESC, "prix"));
		}
		return annonceDao.researchCrit(motCle, ofr, dem, aDesc, rg, ct, vl, part, prof, urg, lpmin, lpmax, lgmin, lgmax,
				ray, new PageRequest(page, 20));

	}

	@RequestMapping("/annonce/get")
	public Annonce get(Long id) {
		return annonceDao.findOne(id);
	}

	@RequestMapping("/annonce/create")
	public Annonce create(@RequestBody Annonce annonce) {
		annonce.setDateDepose(new Date());
		return annonceDao.save(annonce);
	}

	@RequestMapping("/annonce/update")
	public Annonce update(@RequestBody Annonce annonce) {
		annonceDao.saveAndFlush(annonce);
		return annonce;
	}

	@RequestMapping("/annonce/delete")
	public boolean delete(Long id) {
		annonceDao.delete(id);
		return true;
	}

	@RequestMapping("/annonce/deletewithdep")
	public boolean deleteWithDep(Long id) {
		photoDao.deleteByAnnonce(new Annonce(id));
		annonceDao.delete(id);
		return true;
	}
}
