package com.bfi.client;

import javax.persistence.*;
 
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@SequenceGenerator(name="Client_seq", allocationSize = 1)
public abstract class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="Client_seq")
	private long idClient;
	
	
	private String adress;
		
	private String telephone;
	
	private String email; 
	@ManyToOne
	@JoinColumn(name="idVille",nullable=false)
	private Ville ville;
	
	
	
	public Client() {
	}
	
	public Client(String adress, String telephone, String email, Ville ville) {
	
		this.adress = adress;
		this.telephone = telephone;
		this.email = email;
		this.ville = ville;
	}


	public long getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}


	public String getAdress() {
		return adress;
	}



	public void setAdress(String adress) {
		this.adress = adress;
	}




	public Ville getVille() {
		return ville;
	}



	public void setVille(Ville ville) {
		this.ville = ville;
	}


	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", adress=" + adress + ", telephone=" + telephone + ", email=" + email
				+ ", ville=" + ville + "]";
	}


	

	
	


}




