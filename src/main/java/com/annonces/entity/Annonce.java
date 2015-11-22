package com.annonces.entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "ann_annonce")
@AttributeOverride(name = "id", column = @Column(name = "ann_id"))
public class Annonce extends ObjetPersistant{
	
	public Annonce(){
		
	}
	
	public Annonce(Long id){
		this.setId(id);
	}
	
	//0:particulier 1:professionnel
	@Column(name="ann_class", nullable=false, length=1)
	private int classement;
	//0:offre 1:demande
	@Column(name="ann_type", nullable=false, length=1)
	private int type;
	//0:Ouverte 1:Suspendu 2:Cloturer 3:Annuler
	@Column(name="ann_etat", nullable=false, length=1)
	private int etat;
	@Column(name="ann_titre", nullable=false, length=30)
	private String titre;
	@Column(name="ann_descr", nullable=false, length=800)
	private String description;
	@Column(name="ann_prix", nullable=false)
	private float prix;
	@Column(name="ann_lapt")
    private Long laptitude;
	@Column(name="ann_long")
    private Long longitude;
	@Column(name="ann_pseudo", length=10)
    private String pseudo;
	@Column(name="ann_email", length=80)
	private String email;
	@Column(name="ann_numtel", length=30)
    private String numTel;
	@Column(name="ann_masq", nullable=false)
    private boolean masqueNum;
	@Column(name="ann_avecdem", nullable=false)
	private boolean avecDem;
	@Column(name="ann_esturgent", nullable=false)
	private boolean estUrgent;
	@Column(name="ann_imgPrinc")
	private String imagePrincipal;
	@Column(name="ann_datedepose")
	private Date dateDepose;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "cat_id", nullable = false)
	private Categorie categorie;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "cpt_id")
	private Compte compte;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "vil_id", nullable = false)
	private Ville ville;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "reg_id", nullable = false)
	private Region region;
	@Transient
	private String dateAff;
    
	public int getClassement() {
		return classement;
	}
	public void setClassement(int classement) {
		this.classement = classement;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
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
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNumTel() {
		return numTel;
	}
	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}
	public boolean isMasqueNum() {
		return masqueNum;
	}
	public void setMasqueNum(boolean masqueNum) {
		this.masqueNum = masqueNum;
	}
	public boolean isAvecDem() {
		return avecDem;
	}
	public void setAvecDem(boolean avecDem) {
		this.avecDem = avecDem;
	}
	public boolean isEstUrgent() {
		return estUrgent;
	}
	public void setEstUrgent(boolean estUrgent) {
		this.estUrgent = estUrgent;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	public int getEtat() {
		return etat;
	}
	public void setEtat(int etat) {
		this.etat = etat;
	}
	public String getImagePrincipal() {
		return imagePrincipal;
	}
	public void setImagePrincipal(String imagePrincipal) {
		this.imagePrincipal = imagePrincipal;
	}
	public Date getDateDepose() {
		return dateDepose;
	}
	public void setDateDepose(Date dateDepose) {
		this.dateDepose = dateDepose;
	}
	public Ville getVille() {
		return ville;
	}
	public void setVille(Ville ville) {
		this.ville = ville;
	}
	public Region getRegion() {
		return region;
	}
	public void setRegion(Region region) {
		this.region = region;
	}

	public String getDateAff() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:m");
		if(dateDepose != null){
			return dateFormat.format(dateDepose);
		}
		return null;
	}
}
