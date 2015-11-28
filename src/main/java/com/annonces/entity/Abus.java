package com.annonces.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ann_abus")
@AttributeOverride(name = "id", column = @Column(name = "abu_id"))
public class Abus extends ObjetPersistant{
	
	@Column(name="abus_nom", nullable=false)
	private String nom;
	@Column(name="abus_mail", nullable=false)
	private String mail;
	@Column(name="abus_msg", nullable=false)
	private String message;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "mab_id", nullable = false)
	private MotifAbus motifAbus;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ann_id", nullable = false)
	private Annonce annonce;
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public MotifAbus getMotifAbus() {
		return motifAbus;
	}
	public void setMotifAbus(MotifAbus motifAbus) {
		this.motifAbus = motifAbus;
	}
	public Annonce getAnnonce() {
		return annonce;
	}
	public void setAnnonce(Annonce annonce) {
		this.annonce = annonce;
	}
	

}
