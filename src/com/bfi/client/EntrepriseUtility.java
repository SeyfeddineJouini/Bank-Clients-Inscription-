package com.bfi.client;

import javax.persistence.*;

public class EntrepriseUtility {

	public static Entreprise newEntreprise(String adress, long ville, String denominastionSociale,  String telephone, String email, String descriptionActivite, String formeJuridique,
			String structureJuridique, String codeAgentEconomique, String nomContact, String prenomContact,
			String telContact, String emailContact) {
		
		Entreprise e=null;
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_first");
			EntityManager em = emf.createEntityManager();
			EntityTransaction transac = em.getTransaction();

			try {
				transac.begin();
				boolean test = true;
				Ville v = em.find(Ville.class, ville);
				FormeJuridique forme = null;
				switch (formeJuridique) {
				case "Entrepriseindividuelle":
					forme = FormeJuridique.Entrepriseindividuelle;
					break;
				case "EIRL":
					forme = FormeJuridique.EIRL;
					break;
				case "SARL":
					forme = FormeJuridique.SARL;
					break;
				case "EURL":
					forme = FormeJuridique.EURL;
					break;
				case "SAS":
					forme = FormeJuridique.SAS;
					break;
				case "SA":
					forme = FormeJuridique.SA;
					break;
				case "SASU":
					forme = FormeJuridique.SASU;
					break;
				case "SCI":
					forme = FormeJuridique.SCI;
					break;
				case "SNC":
					forme = FormeJuridique.SNC;
					break;
				default:
					test = false;
				}

				StructureJuridique structure = null;
				switch (structureJuridique) {
				case "AssoctiationLoi1901,":
					structure = StructureJuridique.AssoctiationLoi1901;
					break;
				case "EntrepriseInidividuelle":
					structure = StructureJuridique.EntrepriseInidividuelle;
					break;
				case "ExploitantAgricole":
					structure = StructureJuridique.ExploitantAgricole;
					break;
				case "ProfessionLiberale":
					structure = StructureJuridique.ProfessionLiberale;
					break;
				case "SocieteCommerciale":
					structure = StructureJuridique.SocieteCommerciale;
					break;
				case "AUTRE":
					structure = StructureJuridique.AUTRE;
					break;
				default:
					test = false;
				}

				CodeAgentEconomique code = null;
				switch (codeAgentEconomique) {
				case "EntrepriseNonFinanciere":
					code = CodeAgentEconomique.EntrepriseFinanciere;
					break;
				case "AdministrationPublique":
					code = CodeAgentEconomique.AdministrationPublique;
					break;
				case "AdministrationPrivee":
					code = CodeAgentEconomique.AdministrationPrivee;
					break;
				case "EntrepriseFinanciere":
					code = CodeAgentEconomique.EntrepriseFinanciere;
					break;
				case "AUTRE":
					code = CodeAgentEconomique.AUTRE;
					break;
				default:
					test = false;
				}

				if (test) {
					e = new Entreprise(adress, v, denominastionSociale, telephone, email,
							descriptionActivite, forme, structure, code, nomContact, prenomContact, telContact,
							emailContact);
					em.persist(e);
				}
				transac.commit();

			} catch (Exception s) {
				transac.rollback();
				s.printStackTrace();
			} finally {
				em.close();
				emf.close();

			}

		} catch (Exception s) {
			s.printStackTrace();
		}
		return e;
	}

	public static void main(String[] args) {
		newEntreprise("ariana", 2, "isi", "72558996", "isi@gmail.com", "education", "SARL", "AUTRE",
				"AUTRE", "salah", "salhi", "8895545210", "salah@gmail.com");

	}
}
