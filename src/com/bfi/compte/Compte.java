package com.bfi.compte;

import javax.persistence.*;

@Entity
@Table(name = "compte")
@SequenceGenerator(name = "compte_seq", allocationSize = 1)
public class Compte {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "compte_seq")
	private long idCompte;

	private double solde;

	private String numeroCompte;

	private int rib;

	private String description;

	@ManyToOne
	@JoinColumn(name = "id")
	private TypeCompte typeCompte;

	public Compte() {
	}

	public Compte(double solde, String numeroCompte, int rib, String description, TypeCompte typeCompte) {

		this.solde = solde;
		this.numeroCompte = numeroCompte;
		this.rib = rib;
		this.description = description;
		this.typeCompte = typeCompte;
	}

	public long getIdCompte() {
		return idCompte;
	}

	public void setIdCompte(int idCompte) {
		this.idCompte = idCompte;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public String getNumeroComtpe() {
		return numeroCompte;
	}

	public void setNumeroComtpe(String numeroComtpe) {
		this.numeroCompte = numeroComtpe;
	}

	public int getRib() {
		return rib;
	}

	public void setRib(int rib) {
		this.rib = rib;
	}

	public TypeCompte getTypeCompte() {
		return typeCompte;
	}

	public void setTypeCompte(TypeCompte typeCompte) {
		this.typeCompte = typeCompte;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Compte [idCompte=" + idCompte + ", solde=" + solde + ", numeroComtpe=" + numeroCompte + ", rib=" + rib
				+ ", typeCompte=" + typeCompte.toString() + "]";
	}

}
