package com.annonces.idao;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.annonces.entity.Annonce;
import com.annonces.entity.Region;

public interface IAnnonceDao extends JpaRepository<Annonce, Long>{
	
	public Page<Annonce> findByType(int type, Pageable page);
	
	public Page<Annonce> findByRegionAndType(Region reg, int type, Pageable page);
	/*
	@Query(value=" select a.*  " + 
                 " from   ann_annonce a, " + 
                 "        ann_recherche r " +  
                 " where  r.rch_id = :id " +  
                 " and    (r.reg_id = a.reg_id or r.reg_id is null)  " +  
                 " and    (r.cat_id = a.cat_id or r.cat_id is null)   " +
                 " and    r.rch_urgent = a.ann_esturgent   " +
                 " and    r.rch_type = a.ann_type   " +
                 " and    r.rch_classe = a.ann_class   " +
                 " and    UPPER(a.ann_titre) like r.rch_motcle  " + 
                 " and    (r.rch_avecdescr and UPPER(a.ann_descr) like r.rch_motcle or not r.rch_avecdescr)  " +
                 " and    UPPER(a.ann_adr) like r.rch_adresse  " +
                 " and    a.ann_lapt between (r.rch_laptitude - r.rch_rayon) and (r.rch_laptitude + r.rch_rayon)  " +
                 " and    a.ann_long between (r.rch_longitude - r.rch_rayon) and (r.rch_longitude + r.rch_rayon) ")
	public Page<Annonce> researchById(@Param("id") Long id, Pageable page);
	*/
	
	/*
	@Query(value=" select a.*  " + 
                 " from   ann_annonce a " +    
                 " where  (a.reg_id = :r or :r is null)  " +  
                 " and    (a.cat_id = :c or :c is null)   " +
                 " and    a.ann_esturgent :u   " +
                 " and    a.ann_type = :t   " +
                 " and    a.ann_class = :cl   " +
                 " and    UPPER(a.ann_titre) like :m  " + 
                 " and    (:d and UPPER(a.ann_descr) like :m or not :d)  " +
                 " and    UPPER(a.ann_adr) like :a  " +
                 " and    (a.ann_lapt between (:lp - :ry) and (:lp + :ry) or :ry is null) " +
                 " and    (a.ann_long between (:lg - :ry) and (:lg + :ry) or :ry is null) " , nativeQuery=true)
public Page<Annonce> researchByCritere(@Param("r") Long r, @Param("c") Long c, @Param("u") boolean u, @Param("t") int t, @Param("cl") int cl, 
		@Param("m") String m, @Param("d") boolean d, @Param("a") String a, @Param("lp") Long lp, @Param("ry") int ry, @Param("lg") Long lg, Pageable page);
		*/
}
