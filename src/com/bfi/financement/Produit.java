package com.bfi.financement;

import javax.persistence.*;

@Entity
@Table(name = "produit")
@SequenceGenerator(name = "produit_seq",allocationSize = 1)

public class Produit {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "produit_seq")
	private long idProduit;
	
	private String designation;

	public Produit() {
		super();
	}

	public Produit( String designation) {
		
		this.designation = designation;
	}

	public long getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Override
	public String toString() {
		return "Produit [idProduit=" + idProduit + ", designation=" + designation + "]";
	}
	
	
}
