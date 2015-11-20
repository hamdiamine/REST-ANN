package com.annonces.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ann_typecat")
@AttributeOverride(name = "id", column = @Column(name = "tyc_id"))
public class TypeCategorie extends ObjetPersistant{

	@Column(name="tyc_code",nullable=false, length=10)
	private String code;
	@Column(name="tyc_label",nullable=false, length=20)
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
