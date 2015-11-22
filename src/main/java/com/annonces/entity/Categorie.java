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
@Table(name = "ann_categorie")
@AttributeOverride(name = "id", column = @Column(name = "cat_id"))
public class Categorie extends ObjetPersistant{
	
	@Column(name="cat_code",nullable=false, length=10)
	private String code;
	@Column(name="cat_label",nullable=false, length=20)
	private String label;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "tyc_id", nullable = false)
	private TypeCategorie typeCategorie;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public TypeCategorie getTypeCategorie() {
		return typeCategorie;
	}
	public void setTypeCategorie(TypeCategorie typeCategorie) {
		this.typeCategorie = typeCategorie;
	}
	
	
}
