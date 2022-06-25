package com.bfi.financement;

import javax.persistence.*;
@Entity
@Table(name = "lignedefinancement")
@SequenceGenerator(name = "ligne_seq",allocationSize = 1)

public class LigneDeFinancement {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "ligne_seq")
	private long idLigne;
	
	private int dureeDeFinancementSouhaitee;
	
	private  double montantDeFinancementSolicitee;
	
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "idProduit",nullable = false)
	private Produit produit;

	public LigneDeFinancement() {

	}

	public LigneDeFinancement( int dureeDeFinancementSouhaitee,
			double montantDeFinancementSolicitee,String description, Produit produit) {
		this.dureeDeFinancementSouhaitee = dureeDeFinancementSouhaitee;
		this.montantDeFinancementSolicitee = montantDeFinancementSolicitee;
		this.produit = produit;
		this.description=description;
	}

	public long getIdLigneFinancement() {
		return idLigne;
	}

	public void setIdLigneFinancement(int idLigneFinancement) {
		this.idLigne = idLigneFinancement;
	}

	public int getDureeDeFinancementSouhaitee() {
		return dureeDeFinancementSouhaitee;
	}

	public void setDureeDeFinancementSouhaitee(int dureeDeFinancementSouhaitee) {
		this.dureeDeFinancementSouhaitee = dureeDeFinancementSouhaitee;
	}

	public double getMontantDeFinancementSolicitee() {
		return montantDeFinancementSolicitee;
	}

	public void setMontantDeFinancementSolicitee(double montantDeFinancementSolicitee) {
		this.montantDeFinancementSolicitee = montantDeFinancementSolicitee;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "LigneDeFinancement [idLigne=" + idLigne + ", dureeDeFinancementSouhaitee=" + dureeDeFinancementSouhaitee
				+ ", montantDeFinancementSolicitee=" + montantDeFinancementSolicitee + ", produit=" + produit + "]";
	}
	
}
