package com.annonces.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ann_compte")
@AttributeOverride(name = "id", column = @Column(name = "cpt_id"))
public class Compte extends ObjetPersistant {

	@Column(name="cpt_pseudo",nullable=false, length=80)
	private String pseudo;
	@Column(name="cpt_passwd",nullable=false, length=20)
	private String passwd;
	@Column(name="cpt_email",nullable=false, length=80)
	private String email;
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
