package com.annonces.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ann_region")
@AttributeOverride(name = "id", column = @Column(name = "reg_id"))
public class Region extends ObjetPersistant {
	

	public Region() {
		super();
	}
	public Region(Long id, String code, String label) {
		this.setId(id);
		this.code = code;
		this.label = label;
	}
	@Column(name="reg_code",nullable=false, length=10)
	private String code;
	@Column(name="reg_label",nullable=false, length=20)
	private String label;
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
	
	
}
