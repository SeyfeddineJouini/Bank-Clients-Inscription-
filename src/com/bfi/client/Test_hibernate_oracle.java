package com.bfi.client;

import java.util.Base64;

import javax.persistence.*;

import com.bfi.compte.*;
import com.bfi.financement.*;
import com.bfi.relation.EntreeEnRelation;
import com.bfi.relation.Statut;

public class Test_hibernate_oracle {

	public static void main(String[] args) {
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_first");
			EntityManager em = emf.createEntityManager();
			EntityTransaction transac = em.getTransaction();

			try {
				transac.begin();

//villes
				Ville v1 = new Ville("Bardo", 2000);
				Ville v2 = new Ville("Tunis", 1000);
				Ville v3 = new Ville("Ras jbal", 7070);
				Ville v4 = new Ville("Ariana", 2073);

				em.persist(v1);
				em.persist(v2);
				em.persist(v3);
				em.persist(v4);

				// documents
				DocumentsCompte d1 = new DocumentsCompte("pièce identité", "cin", true);
				DocumentsCompte d2 = new DocumentsCompte("justificatif de domicile", "", true);
				DocumentsCompte d3 = new DocumentsCompte("extrait kibis", "", true);
				DocumentsCompte d4 = new DocumentsCompte("attestation de salaire", "attestation", true);
				em.persist(d1);
				em.persist(d2);
				em.persist(d3);
				em.persist(d4);

//type de compte
				TypeCompte t1 = new TypeCompte("Livret NEF", NatureClient.PARTICULIER);
				TypeCompte t2 = new TypeCompte("compte à terme NEF", NatureClient.PARTICULIER);
				TypeCompte t3 = new TypeCompte("compte courant", NatureClient.PARTICULIER);
				TypeCompte t4 = new TypeCompte("Livret OSBL", NatureClient.ENTREPRISE);
				TypeCompte t5 = new TypeCompte("compte courant NEF PRO", NatureClient.ENTREPRISE);
				TypeCompte t6 = new TypeCompte("compte à terme NEF PRO", NatureClient.ENTREPRISE);
				t1.addDoc(d1);
				t1.addDoc(d2);
				t1.addDoc(d3);
				t2.addDoc(d2);
				t2.addDoc(d1);
				t3.addDoc(d2);
				t4.addDoc(d4);
				t5.addDoc(d4);
				t5.addDoc(d3);
				t6.addDoc(d4);
				em.persist(t1);
				em.persist(t2);
				em.persist(t3);
				em.persist(t4);
				em.persist(t5);
				em.persist(t6);
//particulier
				Particulier p1 = new Particulier("bardo", v1, "jouini", "seyf", 2000, 4, 3, "8585252",
						"dfesf@gmail.com", "tunis", "tunisie", 2021, 7, 1, "nom1", "info", Civilite.Monsieur,
						TypeLogement.DomicileFamilialDesParents, Profession.AUTRE, TypeContrat.CDD,
						SecteurActiviteEmployeur.EtablissementFinanccier, TailleEmployeur.GE);
				// Entreprise
				Entreprise e1 = new Entreprise("lac", v2, "bfi", "965859659", "bfi@gmail.com", "finance",
						FormeJuridique.SARL, StructureJuridique.SocieteCommerciale,
						CodeAgentEconomique.AdministrationPrivee, "mohamed", "ahmed", "0038895747",
						"mohamed@gmail.com");

				// categorie projet
				CategorieProjet categ1 = new CategorieProjet("activité d'insertion");
				CategorieProjet categ2 = new CategorieProjet("artisanat");
				em.persist(categ1);
				em.persist(categ2);

				// documentfinancement
				String c = "c2VsZWN0ICdkcm9wIHNlcXVlbmNlICcgfHwgc2VxdWVuY2VfbmFtZSB8fCAnOycgZnJvbSB1c2VyX3NlcXVlbmNlczsg";
				byte[] decodedArr = Base64.getDecoder().decode(c);
				DocumentsFinancement doc1 = new DocumentsFinancement("attestaion salaire", "", decodedArr);
				DocumentsFinancement doc2 = new DocumentsFinancement("justificatif domicile", "", decodedArr);
				em.persist(doc1);
				em.persist(doc2);

				// produit

				Produit prod = new Produit("produit 1");
				em.persist(prod);
				// Ligne de financement

				LigneDeFinancement l1 = new LigneDeFinancement(2, 15220.0, "description1", prod);

				LigneDeFinancement l2 = new LigneDeFinancement(2, 15220.0, "description2", prod);
				em.persist(l1);
				em.persist(l2);
				// Secteur du projet
				SecteurProjet s1 = new SecteurProjet("secteur1");
				SecteurProjet s2 = new SecteurProjet("secteur 2");
				em.persist(s1);
				em.persist(s2);
				// situation géographique du projet

				SituationGeographiqueProjet situation1 = new SituationGeographiqueProjet("situation 1");
				em.persist(situation1);
				// type financement
				TypeDeFinancement tfin1 = new TypeDeFinancement("type1");
				em.persist(tfin1);
//comptes
				Compte c1 = new Compte(100.75, "111", 12, "compte111", t1);
				Compte c2 = new Compte(45879.75, "222", 1355, "compte222", t2);
				Compte c3 = new Compte(785.75, "333", 442, "compte333", t3);
				Compte c4 = new Compte(95292.75, "444", 77, "compte444", t4);
				Compte c5 = new Compte(75.75, "555", 85569, "compte555", t5);
				Compte c6 = new Compte(996.75, "666", 85562, "compte666", t6);

				// Demande financement

				DemandeFinancement demande1 = new DemandeFinancement("tunis 1", 21500.0, "desc1", situation1, s1, tfin1,
						categ1);
				demande1.addLigne(l1);
				DemandeFinancement demande2 = new DemandeFinancement("tunis 1", 3500.0, "desc2", situation1, s2, tfin1,
						categ2);
				demande2.addLigne(l2);
				em.persist(demande1);
				em.persist(demande2);

				em.persist(c1);
				em.persist(c2);
				em.persist(c3);
				em.persist(c4);
				em.persist(c5);
				em.persist(c6);

				em.persist(p1);
				em.persist(e1);

				EntreeEnRelation relation = new EntreeEnRelation("", "", Statut.ENCOURS, p1, demande1);
				em.persist(relation);

				transac.commit();
			} catch (Exception e) {
				transac.rollback();
				e.printStackTrace();
			} finally {
				em.close();
				emf.close();

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}