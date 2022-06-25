package com.bfi.financement;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "demande")
@SequenceGenerator(name = "financement_seq", allocationSize = 1)
public class DemandeFinancement {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "financement_seq")
	private long idDemande;

	private String delegation;

	private double coutProjet;
	
	private String description;

	@ManyToOne
	@JoinColumn(name = "idSituation", nullable = false)
	private SituationGeographiqueProjet situationGeoProjet;

	@ManyToOne
	@JoinColumn(name = "idSecteur", nullable = false)
	private SecteurProjet secteurProjet;

	@ManyToOne
	@JoinColumn(name = "idType", nullable = false)
	private TypeDeFinancement typeFinancement;

	@ManyToOne
	@JoinColumn(name = "idCategorie", nullable = false)
	private CategorieProjet categorieProjet;

	@OneToMany(cascade = CascadeType.ALL)
	private Set<LigneDeFinancement> ligneDeFinancement;

	@OneToMany(cascade = CascadeType.ALL)
	private Set<DocumentsFinancement> docFinancement;

	public DemandeFinancement() {

	}

	public DemandeFinancement(String delegation, double coutProjet, String description,
			SituationGeographiqueProjet situationGeoProjet, SecteurProjet secteurProjet,
			TypeDeFinancement typeFinancement, CategorieProjet categorieProjet) {
		this.delegation = delegation;
		this.coutProjet = coutProjet;
		this.situationGeoProjet = situationGeoProjet;
		this.secteurProjet = secteurProjet;
		this.typeFinancement = typeFinancement;
		this.categorieProjet = categorieProjet;
		this.docFinancement = new HashSet<DocumentsFinancement>();
		this.ligneDeFinancement = new HashSet<LigneDeFinancement>();
		this.description = description;

	}

	public void addLigne(LigneDeFinancement l) {
		ligneDeFinancement.add(l);
	}

	public void addDoc(DocumentsFinancement d) {
		docFinancement.add(d);
	}

	public long getIdDemande() {
		return idDemande;
	}

	public void setIdDemande(int idDemande) {
		this.idDemande = idDemande;
	}

	public String getDelegation() {
		return delegation;
	}

	public void setDelegation(String delegation) {
		this.delegation = delegation;
	}

	public double getCoutProjet() {
		return coutProjet;
	}

	public void setCoutProjet(double coutProjet) {
		this.coutProjet = coutProjet;
	}

	public SituationGeographiqueProjet getSituationGeoProjet() {
		return situationGeoProjet;
	}

	public void setSituationGeoProjet(SituationGeographiqueProjet situationGeoProjet) {
		this.situationGeoProjet = situationGeoProjet;
	}

	public SecteurProjet getSecteurProjet() {
		return secteurProjet;
	}

	public void setSecteurProjet(SecteurProjet secteurProjet) {
		this.secteurProjet = secteurProjet;
	}

	public TypeDeFinancement getTypeFinancement() {
		return typeFinancement;
	}

	public void setTypeFinancement(TypeDeFinancement typeFinancement) {
		this.typeFinancement = typeFinancement;
	}

	public CategorieProjet getCategorieProjet() {
		return categorieProjet;
	}

	public void setCategorieProjet(CategorieProjet categorieProjet) {
		this.categorieProjet = categorieProjet;
	}

	public Set<LigneDeFinancement> getLigneDeFinancement() {
		return ligneDeFinancement;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "DemandeFinancement [idDemande=" + idDemande + ", delegation=" + delegation + ", coutProjet="
				+ coutProjet + ", situationGeoProjet=" + situationGeoProjet + ", secteurProjet=" + secteurProjet
				+ ", typeFinancement=" + typeFinancement + ", categorieProjet=" + categorieProjet
				+ ", ligneDeFinancement=" + ligneDeFinancement + ", docFinancement=" + docFinancement + "]";
	}

}
