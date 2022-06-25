package com.bfi.financement;

import javax.persistence.*;

@Entity
@Table(name = "docfinance")
@SequenceGenerator(name = "docfinance_seq", allocationSize = 1)
public class DocumentsFinancement {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "docfinance_seq")
	private long idDoc;

	private String nom;

	private String description;

	@Lob
	@Column(name = "contenu", columnDefinition = "BLOB")
	private byte[] contenu;

	public DocumentsFinancement() {
		super();
	}

	public DocumentsFinancement(String nom, String description, byte[] contenu) {
		this.nom = nom;
		this.description = description;
		this.contenu = contenu;
	}

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

	public byte[] getContenu() {
		return contenu;
	}

	public void setContenu(byte[] contenu) {
		this.contenu = contenu;
	}

	@Override
	public String toString() {
		return "DocumentsFinancement [idDoc=" + idDoc + ", nom=" + nom + ", description=" + description + "]";
	}

}
