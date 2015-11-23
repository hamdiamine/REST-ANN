package com.annonces.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "ann_recherche")
@AttributeOverride(name = "id", column = @Column(name = "rch_id"))
public class Recherche extends ObjetPersistant{

	@Column(name="rch_title", length=40)
	private String title;
	@Column(name="rch_motcle", length=400)
	private String motsCle;
	@Column(name="rch_avecdescr")
	private boolean avecDesc;
	@Column(name="rch_offre")
	private boolean offre;
	@Column(name="rch_demande")
	private boolean demande;
	@Column(name="rch_laptitude")
	private Long laptitude;
	@Column(name="rch_longitude")
	private Long longitude;
	@Column(name="rch_partic")
	private boolean particulier;
	@Column(name="rch_profess")
	private boolean professionnel;
	@Column(name="rch_urgent")
	private boolean urgent;
	@Column(name="rch_rayon")
	private int rayon;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "cat_id")
	private Categorie categorie;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "reg_id")
	private Region region;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "vil_id")
	private Ville ville;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "cpt_id")
	private Compte compte;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMotsCle() {
		return motsCle;
	}
	public void setMotsCle(String motsCle) {
		this.motsCle = motsCle;
	}
	public boolean isAvecDesc() {
		return avecDesc;
	}
	public void setAvecDesc(boolean avecDesc) {
		this.avecDesc = avecDesc;
	}
	public Region getRegion() {
		return region;
	}
	public void setRegion(Region region) {
		this.region = region;
	}
	public Long getLaptitude() {
		return laptitude;
	}
	public void setLaptitude(Long laptitude) {
		this.laptitude = laptitude;
	}
	public Long getLongitude() {
		return longitude;
	}
	public void setLongitude(Long longitude) {
		this.longitude = longitude;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public boolean isUrgent() {
		return urgent;
	}
	public void setUrgent(boolean urgent) {
		this.urgent = urgent;
	}
	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	public int getRayon() {
		return rayon;
	}
	public void setRayon(int rayon) {
		this.rayon = rayon;
	}
	public boolean isOffre() {
		return offre;
	}
	public void setOffre(boolean offre) {
		this.offre = offre;
	}
	public boolean isDemande() {
		return demande;
	}
	public void setDemande(boolean demande) {
		this.demande = demande;
	}
	public boolean isParticulier() {
		return particulier;
	}
	public void setParticulier(boolean particulier) {
		this.particulier = particulier;
	}
	public boolean isProfessionnel() {
		return professionnel;
	}
	public void setProfessionnel(boolean professionnel) {
		this.professionnel = professionnel;
	}
	public Ville getVille() {
		return ville;
	}
	public void setVille(Ville ville) {
		this.ville = ville;
	}
	
	
}
