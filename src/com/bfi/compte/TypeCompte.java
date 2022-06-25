package com.bfi.compte;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "typeCompte")
@SequenceGenerator(name = "typecompte_seq",allocationSize = 1)
public class TypeCompte {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "typecompte_seq ")
	private long id;
	
	private String libele;
	
	private NatureClient natureClient;
	
	@OneToMany(mappedBy = "type")
	private Set<DocumentsCompte> documents;

	public TypeCompte( String libele, NatureClient natureClient) {
		
		this.libele = libele;
		this.natureClient = natureClient;
		this.documents=new HashSet<DocumentsCompte>();
	}
	
	public TypeCompte() {}
	
	public void addDoc(DocumentsCompte doc) {
		this.documents.add(doc);
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibele() {
		return libele;
	}

	public void setLibele(String libele) {
		this.libele = libele;
	}

	public NatureClient getNatureClient() {
		return natureClient;
	}

	public void setNatureClient(NatureClient natureClient) {
		this.natureClient = natureClient;
	}

	public void setDocuments(Set<DocumentsCompte> documents) {
		this.documents = documents;
	}

	@Override
	public String toString() {
		return "TypeCompte [id=" + id + ", libele=" + libele + ", natureClient=" + natureClient + ", documents="
				+ documents + "]";
	}
	
	
	
	
	
}
