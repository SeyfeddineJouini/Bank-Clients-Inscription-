package com.bfi.client;

import javax.persistence.*;
import java.util.*;
@Entity
@Table(name="particulier")
public class Particulier extends Client {
	
	private String nom;
	
	private String prenom;
		
	private Date dateNaissance;
	
	private String lieuNaissance;

	private String nationality;
	
	private Date dateEntreeEmploi;
	
	private String nomEmployeur;
	
	private String secteurActivite;
	
	
	@Enumerated(EnumType.STRING)
	private Civilite civilite;
	@Enumerated(EnumType.STRING)
	private TypeLogement typeLogement;
	@Enumerated(EnumType.STRING)
	private Profession profession;
	@Enumerated(EnumType.STRING)
	private TypeContrat typeContrat;
	@Enumerated(EnumType.STRING)
	private SecteurActiviteEmployeur secteurActiviteEmployeur;
	@Enumerated(EnumType.STRING)
	private TailleEmployeur tailleEmployeur;

	public Particulier() {
		
	}
	public Particulier(String adress,Ville ville,String nom, String prenom,int annee,int mois,int jour,
			String telephone, String email, String lieuNaissance, String nationality,
			int annee1,int mois1,int jour1, String nomEmployeur, String secteurActivite, 
			Civilite civilite, TypeLogement typeLogement, Profession profession, TypeContrat typeContrat,
			SecteurActiviteEmployeur secteurActiviteEmployeur, TailleEmployeur tailleEmployeur) {
		super(adress, telephone, email,ville);
		this.nom = nom;
		this.prenom = prenom;
		Calendar c= new GregorianCalendar(annee, mois-1, jour);
		this.dateNaissance = c.getTime();
		this.lieuNaissance = lieuNaissance;
		this.nationality = nationality;
		c= new GregorianCalendar(annee1, mois1-1, jour1);
		this.dateEntreeEmploi = c.getTime();
		this.nomEmployeur = nomEmployeur;
		this.secteurActivite = secteurActivite;
		this.civilite = civilite;
		this.typeLogement = typeLogement;
		this.profession = profession;
		this.typeContrat = typeContrat;
		this.secteurActiviteEmployeur = secteurActiviteEmployeur;
		this.tailleEmployeur = tailleEmployeur;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public Date getDateNaissance() {
		return dateNaissance;
	}


	public void setDateNaissance(int annee,int mois,int jour) {

		Calendar c= new GregorianCalendar(annee, mois-1, jour);
		this.dateNaissance = c.getTime();
	}


	public String getLieuNaissance() {
		return lieuNaissance;
	}


	public void setLieuNaissance(String lieuNaissance) {
		this.lieuNaissance = lieuNaissance;
	}


	public String getNationality() {
		return nationality;
	}


	public void setNationality(String nationality) {
		this.nationality = nationality;
	}


	public Date getDateEntreeEmploi() {
		return dateEntreeEmploi;
	}


	public void setDateEntreeEmploi(int annee1,int mois1,int jour1) {
		Calendar c= new GregorianCalendar(annee1, mois1-1, jour1);
		this.dateEntreeEmploi = c.getTime();
	}


	public String getNomEmployeur() {
		return nomEmployeur;
	}


	public void setNomEmployeur(String nomEmployeur) {
		this.nomEmployeur = nomEmployeur;
	}


	public String getSecteurActivite() {
		return secteurActivite;
	}


	public void setSecteurActivite(String secteurActivite) {
		this.secteurActivite = secteurActivite;
	}





	public Civilite getCivilite() {
		return civilite;
	}


	public void setCivilite(Civilite civilite) {
		this.civilite = civilite;
	}


	public TypeLogement getTypeLogement() {
		return typeLogement;
	}


	public void setTypeLogement(TypeLogement typeLogement) {
		this.typeLogement = typeLogement;
	}


	public Profession getProfession() {
		return profession;
	}


	public void setProfession(Profession profession) {
		this.profession = profession;
	}


	public TypeContrat getTypeContrat() {
		return typeContrat;
	}


	public void setTypeContrat(TypeContrat typeContrat) {
		this.typeContrat = typeContrat;
	}


	public SecteurActiviteEmployeur getSecteurActiviteEmployeur() {
		return secteurActiviteEmployeur;
	}


	public void setSecteurActiviteEmployeur(SecteurActiviteEmployeur secteurActiviteEmployeur) {
		this.secteurActiviteEmployeur = secteurActiviteEmployeur;
	}


	public TailleEmployeur getTailleEmployeur() {
		return tailleEmployeur;
	}


	public void setTailleEmployeur(TailleEmployeur tailleEmployeur) {
		this.tailleEmployeur = tailleEmployeur;
	}
	@Override
	public String toString() {
		return super.toString()+"Particulier nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance
				+ ", lieuNaissance=" + lieuNaissance + ", nationality=" + nationality + ", dateEntreeEmploi="
				+ dateEntreeEmploi + ", nomEmployeur=" + nomEmployeur + ", secteurActivite=" + secteurActivite
				+ ", civilite=" + civilite + ", typeLogement=" + typeLogement + ", profession=" + profession
				+ ", typeContrat=" + typeContrat + ", secteurActiviteEmployeur=" + secteurActiviteEmployeur
				+ ", tailleEmployeur=" + tailleEmployeur + "]";
	}
	

}
