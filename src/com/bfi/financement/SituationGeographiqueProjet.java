package com.bfi.financement;

import javax.persistence.*;
@Entity
@Table(name = "situationGeographique")
@SequenceGenerator(name = "situation_seq",allocationSize = 1)
public class SituationGeographiqueProjet {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "situation_seq")
	private long idSituation;
	
	private String libelle;

	public SituationGeographiqueProjet() {
		super();
	}

	public SituationGeographiqueProjet(String libelle) {
		this.libelle = libelle;
	}

	public long getIdsituation() {
		return idSituation;
	}

	public void setIdsituation(int idsituation) {
		this.idSituation = idsituation;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@Override
	public String toString() {
		return "SituationGeographiqueProjet [idSituation=" + idSituation + ", libelle=" + libelle + "]";
	}
	
	
}
