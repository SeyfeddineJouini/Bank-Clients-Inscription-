package com.bfi.financement;
import javax.persistence.*;

@Entity
@Table(name = "categorieprojet")
@SequenceGenerator(name = "categorieprojet_seq",allocationSize = 1)
public class CategorieProjet {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "categorieprojet_seq")
	private long idCategorie;
	
	private String categorie;

	public CategorieProjet() {
	
	}

	public CategorieProjet(String categorie) {
	
		this.categorie = categorie;
	}

	public long getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	@Override
	public String toString() {
		return "CategorieProjet [idCategorie=" + idCategorie + ", categorie=" + categorie + "]";
	}
	
	
}
