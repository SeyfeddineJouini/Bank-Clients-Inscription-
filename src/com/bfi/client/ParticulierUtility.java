package com.bfi.client;
import javax.persistence.*;
public class ParticulierUtility {
	
	public static Particulier newparticulier(String adress,long ville,String nom, String prenom,int annee,int mois,int jour,
			String telephone, String email, String lieuNaissance, String nationality,
			int annee1,int mois1,int jour1, String nomEmployeur, String secteurActivite, 
			String civilite, String typeLogement, String profession, String typeContrat,
			String secteurActiviteEmployeur, String tailleEmployeur) {
		Particulier p=null;
		try {
			EntityManagerFactory emf= Persistence.createEntityManagerFactory("jpa_first");
			EntityManager em=emf.createEntityManager();
			EntityTransaction transac=em.getTransaction();
		
		try {
			transac.begin();

			Ville v=em.find(Ville.class, ville);
			Civilite civi=null;
			switch(civilite) {
			case "Monsieur":civi=Civilite.Monsieur;break;
			case "Madame":civi=Civilite.Madame;break;
			default:
			}
			
			
			TypeLogement typeLog=null;
			switch(typeLogement) {
			case "Locataire":typeLog=TypeLogement.Locataire;break;
			case "DomicileFamilialDesParents":typeLog=TypeLogement.DomicileFamilialDesParents;break;
			case "Autre":typeLog=TypeLogement.Autre;break;
			default:			
			}
			
			
			Profession profe=null;
			switch(profession) {
			case "OUVRIER":profe=Profession.OUVRIER;break;
			case "RETRAITE":profe=Profession.RETRAITE;break;
			case "DIRIGEANT":profe=Profession.DIRIGEANT;break;
			case "CADRE":profe=Profession.CADRE;break;
			case"AUTRE":profe=Profession.AUTRE;break;
			default: 
			}
			
			
			TypeContrat typeCo=null;
			switch(typeContrat) {
			case "CdiTitulaire":typeCo=TypeContrat.CdiTitulaire;break;
			case"CDD":typeCo=TypeContrat.CDD;break;
			case "CONTRACTUEL":typeCo=TypeContrat.CONTRACTUEL;break;
			case "RETAITE":typeCo=TypeContrat.RETAITE;break;
			case "TRAVAILLEURINDEPENDANTS":typeCo=TypeContrat.TRAVAILLEURINDEPENDANTS;break;
			default:
			}
			
			
			SecteurActiviteEmployeur secteur=null;
			switch(secteurActiviteEmployeur) {
			case "EtablissementFinanccier":secteur=SecteurActiviteEmployeur.EtablissementFinanccier;break;
			case "PUBLIC":secteur=SecteurActiviteEmployeur.PUBLIC;break;
			case "AUTRE":secteur=SecteurActiviteEmployeur.AUTRE;break;
			default:
			}
			
			
			TailleEmployeur taille=null;
			switch(tailleEmployeur) {
			case "SecteurPublic":taille=TailleEmployeur.SecteurPublic;break;
			case "GE":taille=TailleEmployeur.GE;break;
			case "PME": taille=TailleEmployeur.PME;break;
			case "TPE": taille=TailleEmployeur.TPE;break;
			default:
			}
			p=new Particulier(adress, v, nom, prenom, annee, mois, jour, telephone, email,
					lieuNaissance, nationality, annee1, mois1, jour1, nomEmployeur, secteurActivite, civi,
					typeLog, profe, typeCo, secteur, taille);
			em.persist(p);
			transac.commit();
		}
		catch(Exception e){
			  transac.rollback();
			  e.printStackTrace();
		  }
		  finally {
		  em.close();
		  emf.close();

		          }

		          }
		  catch (Exception e) {
		  e.printStackTrace();
		  }
		return p;
		}
	public static void main (String[]args) {
		newparticulier("manzel tmim",3,"ahmed", "mohamed", 2002, 8, 12, "00385865",
				  "svfef@gmail.com", "tunis", "tunisie", 2021, 7, 1, "nom1", "info",
				  "Monsieur", "Locataire","DIRIGEANT","CONTRACTUEL", "PUBLIC","TPE");
	}
	}
		
