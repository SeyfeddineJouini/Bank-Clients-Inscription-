package com.bfi.client;

import javax.persistence.*;

@Entity
@Table(name = "ville")
@SequenceGenerator(name="ville_seq",allocationSize=1)
public class Ville {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="ville_seq")
	private long idVille;
	
	private String designation;
	
	private int codePostal;
	
	public Ville () {
	}
	
	
	public Ville(String designation, int codePostal) {
		
		this.designation = designation;
		this.codePostal = codePostal;
	}

	public long getId_ville() {
		return idVille;
	}

	public void setId_ville(int id_ville) {
		this.idVille = id_ville;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}


	public int getCodePostal() {
		return codePostal;
	}


	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}


	@Override
	public String toString() {
		return "Ville [idVille=" + idVille + ", designation=" + designation + ", codePostal=" + codePostal + "]";
	}

	

}
