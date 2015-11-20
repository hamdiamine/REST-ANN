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
	//0:Offre 1: Demande
	@Column(name="rch_type", length=1)
	private int type;
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@JoinColumn(name = "reg_id")
	private Region region;
	@Column(name="rch_adresse", length=100)
	private String adresse;
	@Column(name="rch_laptitude")
	private Long laptitude;
	@Column(name="rch_longitude")
	private Long longitude;
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@JoinColumn(name = "cat_id")
	private Categorie categorie;
	//0:Partculier 1:Proffessionnel
	@Column(name="rch_classe", length=1)
	private int classe;
	@Column(name="rch_urgent")
	private boolean urgent;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "cpt_id")
	private Compte compte;
	@Column(name="rch_rayon")
	private int rayon;
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
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Region getRegion() {
		return region;
	}
	public void setRegion(Region region) {
		this.region = region;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
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
	public int getClasse() {
		return classe;
	}
	public void setClasse(int classe) {
		this.classe = classe;
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
	
}
