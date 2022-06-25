package com.bfi.relation;

import javax.persistence.*;
import java.util.*;
import com.bfi.client.*;
import com.bfi.compte.*;
import com.bfi.financement.*;

@Entity
@Table(name="Relation")
@SequenceGenerator(name = "relation_seq",allocationSize=1)
public class EntreeEnRelation {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "relation_seq")
	private long idRelation;
	
	private Date dateDemande;
	
	private Date dateDecision;
	
	private String commentaireClient;
	
	private String commentaireBanque;
	
	private Statut statut;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idClient",nullable = false)
	private Client client;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idDemande")
	private DemandeFinancement demande;
	
	@OneToMany(cascade = CascadeType.ALL)
	private  List<Compte> comptes;
	
	
	
	public EntreeEnRelation() {}



	public EntreeEnRelation(  String commentaireClient, String commentaireBanque,
			Statut statut, Client client, DemandeFinancement demande) {
		this.dateDemande =new Date();
		this.dateDecision=new Date();
		this.commentaireClient = commentaireClient;
		this.commentaireBanque = commentaireBanque;
		this.statut = statut;
		this.client = client;
		this.demande = demande;
		this.comptes =new ArrayList<Compte>();
	}

	public void addCompte(Compte c) {
		comptes.add(c);
	}

	public long getIdRelation() {
		return idRelation;
	}

	public void setIdRelation(int idRelation) {
		this.idRelation = idRelation;
	}

	public Date getDateDemande() {
		return dateDemande;
	}

	public void setDateDemande(Date dateDemande) {
		this.dateDemande = dateDemande;
	}

	public Date getDateDecision() {
		return dateDecision;
	}

	public void setDateDecision(int anneeDecision,int moisDecision,int jourDecision) {
		Calendar c= new GregorianCalendar(anneeDecision, moisDecision-1, jourDecision);
		this.dateDecision = c.getTime();
	}

	public String getCommentaireClient() {
		return commentaireClient;
	}

	public void setCommentaireClient(String commentaireClient) {
		this.commentaireClient = commentaireClient;
	}

	public String getCommentaireBanque() {
		return commentaireBanque;
	}

	public void setCommentaireBanque(String commentaireBanque) {
		this.commentaireBanque = commentaireBanque;
	}

	public Statut getStatut() {
		return statut;
	}

	public void setStatut(Statut statut) {
		this.statut = statut;
	}



	public Client getClient() {
		return client;
	}



	public void setClient(Client client) {
		this.client = client;
	}



	public DemandeFinancement getDemande() {
		return demande;
	}



	public void setDemande(DemandeFinancement demande) {
		this.demande = demande;
	}



	public List<Compte> getCompte() {
		return comptes;
	}



	@Override
	public String toString() {
		return "EntreeEnRelation [idRelation=" + idRelation + ", dateDemande=" + dateDemande + ", dateDecision="
				+ dateDecision + ", commentaireClient=" + commentaireClient + ", commentaireBanque=" + commentaireBanque
				+ ", statut=" + statut + ", client=" + client + ", demande=" + demande + ", compte=" + comptes + "]";
	}
	
	
	
	
	

}
