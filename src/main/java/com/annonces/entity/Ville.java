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
@Table(name = "ann_ville")
@AttributeOverride(name = "id", column = @Column(name = "vil_id"))
public class Ville extends ObjetPersistant{
	
	public Ville(){
		super();
	}
	
	public Ville(Long id){
		setId(id);
	}
   
	@Column(name="vil_label", nullable=false)
	private String label;
	@Column(name="vil_codePostal", nullable=false)
	private String codePotal;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "reg_id", nullable = false)
	private Region region;
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getCodePotal() {
		return codePotal;
	}
	public void setCodePotal(String codePotal) {
		this.codePotal = codePotal;
	}
	public Region getRegion() {
		return region;
	}
	public void setRegion(Region region) {
		this.region = region;
	}
	
}
