package com.annonces.idao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.annonces.entity.Annonce;
import com.annonces.entity.Categorie;
import com.annonces.entity.Region;
import com.annonces.entity.Ville;

public interface IAnnonceDao extends JpaRepository<Annonce, Long> {

	public Page<Annonce> findByType(int type, Pageable page);

	public Page<Annonce> findByRegionAndType(Region reg, int type, Pageable page);

	@Query(" from Annonce a " + " where (a.categorie = :cat or :cat is null) "
			+ " and   (a.ville = :vil or :vil is null) " + " and   (a.region = :reg or :reg is null) "
			+ " and   (a.type = 0 and :ofr=true or :ofr=false) " + " and   (a.type = 1 and :dem=true or :dem=false) "
			+ " and   (a.classement = 0 and :part=true or :part=false) " + " and   (a.classement = 1 and :prof=true or :prof=false) "
			+ " and   (a.estUrgent = true or :urg=false) "
			+ " and   ((upper(a.titre) like :mCle and :aDesc=false) or (upper(a.titre||' '||a.description) like :mCle and :aDesc=true)) "
			+ " and   ((a.laptitude between :lpmin and :lpmax) or (a.longitude between :lgmin and :lgmax) or :ray is null) ")
	public Page<Annonce> researchCrit(@Param("mCle") String mCle, @Param("ofr") boolean ofr, @Param("dem") boolean dem,
			@Param("aDesc") boolean aDesc, @Param("reg") Region reg, @Param("cat") Categorie cat,
			@Param("vil") Ville vil, @Param("part") boolean part, @Param("prof") boolean prof,
			@Param("urg") boolean urg, @Param("lpmin") Double lpmin, @Param("lpmax") Double lpmax,
			@Param("lgmin") Double lgmin, @Param("lgmax") Double lgmax, @Param("ray") Integer ray, Pageable page);

}
