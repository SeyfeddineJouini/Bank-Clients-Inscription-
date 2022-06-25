package com.bfi.financement;

import javax.persistence.*;

@Entity
@Table(name = "secteurProjet")
@SequenceGenerator(name = "secteur_seq",allocationSize = 1)
public class SecteurProjet {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "secteur_seq")
	private long idSecteur;
	
	private String secteur;

	public SecteurProjet() {
		super();
	}

	public SecteurProjet( String secteur) {
		this.secteur = secteur;
	}

	public long getIdSecteur() {
		return idSecteur;
	}

	public void setIdSecteur(int idSecteur) {
		this.idSecteur = idSecteur;
	}

	public String getSecteur() {
		return secteur;
	}

	public void setSecteur(String secteur) {
		this.secteur = secteur;
	}

	@Override
	public String toString() {
		return "SecteurProjet [idSecteur=" + idSecteur + ", secteur=" + secteur + "]";
	}
	
	
}
