package com.bfi.compte;

import javax.persistence.*;
@Entity
@Table(name = "documentCompte")
@SequenceGenerator(name = "documentscompte_seq",allocationSize = 1)
public class DocumentsCompte {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "documentscompte_seq")
	private long idDoc;
	
	private String nom;
	
	private String description;
	
	private boolean obligatoire;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	private TypeCompte type;
	
	public DocumentsCompte( String nom, String description, boolean essence) {
	
		this.nom = nom;
		this.description = description;
		this.obligatoire = essence;
	}
	public DocumentsCompte() {}
	public long getIdDoc() {
		return idDoc;
	}
	public void setIdDoc(int idDoc) {
		this.idDoc = idDoc;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isEssence() {
		return obligatoire;
	}
	public void setEssence(boolean essence) {
		this.obligatoire = essence;
	}
	
	
	
	
	
}
