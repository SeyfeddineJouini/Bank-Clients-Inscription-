package com.bfi.relation;

import java.io.File;
import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.bfi.client.*;
import com.bfi.compte.*;
import com.bfi.financement.*;
import java.nio.file.*;
public class EntreeEnRelationUtility {

	public static void newRelation(String commentaireClient, String commentaireBanque, String statut,
			Map<String, Object> client, Map<String, Object> demande, List<Map<String, Object>> compte) {

		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_first");
			EntityManager em = emf.createEntityManager();
			EntityTransaction transac = em.getTransaction();

			try {
				transac.begin();
				Client cli;
				if (((String) client.get("nature")).equals("particulier")) {

					cli = ParticulierUtility.newparticulier((String) client.get("adress"), (long) client.get("ville"),
							(String) client.get("nom"), (String) client.get("prenom"), (int) client.get("annee"),
							(int) client.get("mois"), (int) client.get("jour"), (String) client.get("telephone"),
							(String) client.get("email"), (String) client.get("lieuNaissance"),
							(String) client.get("nationality"), (int) client.get("annee1"), (int) client.get("mois1"),
							(int) client.get("jour1"), (String) client.get("nomEmployeur"),
							(String) client.get("secteurActivite"), (String) client.get("civilite"),
							(String) client.get("typeLogement"), (String) client.get("profession"),
							(String) client.get("typeContrat"), (String) client.get("secteurActiviteEmployeur"),
							(String) client.get("tailleEmployeur"));
				} else {
					cli = EntrepriseUtility.newEntreprise((String) client.get("adress"), (long) client.get("ville"),
							(String) client.get("denominastionSociale"), (String) client.get("telephone"),
							(String) client.get("email"), (String) client.get("descriptionActivite"),
							(String) client.get("formeJuridique"), (String) client.get("structureJuridique"),
							(String) client.get("codeAgentEconomique"), (String) client.get("nomContact"),
							(String) client.get("prenomContact"), (String) client.get("telContact"),
							(String) client.get("emailContact"));

				}

				@SuppressWarnings("unchecked")
				DemandeFinancement dem = DemandeFinancementUtility.newdemande((String) demande.get("delegation"),
						(double) demande.get("coutProjet"), (String) demande.get("descritpion"),
						(long) demande.get("situationGeoProjet"), (long) demande.get("secteurProjet"),
						(long) demande.get("typeFinancement"), (long) demande.get("categorieProjet"),
						(List<Map<String, Object>>) demande.get("lignes"),
						(List<Map<String, Object>>) demande.get("doc"));

				Statut stat = null;
				switch (statut) {
				case "ENCOURS":
					stat = Statut.ENCOURS;
					break;
				case "REJETEE":
					stat = Statut.REJETEE;
					break;
				case "ACCEPTEE":
					stat = Statut.ACCEPTEE;
					break;
				case "ANNULEE":
					stat = Statut.ANNULEE;
					break;
				default:
				}
				EntreeEnRelation entree = new EntreeEnRelation(commentaireClient, commentaireBanque, stat, cli, dem);

				List<Compte> comptes = CompteUtility.newComptes(compte);
				for (Compte m : comptes) {
					entree.addCompte(m);
				}

				em.merge(entree);
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

	public static void main(String[] args) {

		// MAP CLIENTS
		Map<String, Object> client = new HashMap<String, Object>();
		try {

			File xmlDoc = new File("C:\\eer\\xml");
			if (xmlDoc.isDirectory()) {
				if (xmlDoc.list().length > 0) {
					 String contents[] = xmlDoc.list();
					 for(int i=0; i<contents.length; i++) {
				         
					File document = new File("C:\\"+"\\"+"eer\\"+"\\"+"xml\\"+"\\"+contents[i]);
					DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
					DocumentBuilder db = dbf.newDocumentBuilder();
					Document doc = db.parse(document);

					NodeList nlist = doc.getElementsByTagName("client");
					Node nNode = nlist.item(0);
					System.out.println("node name: " + nNode.getNodeName());
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {

						Element eElement = (Element) nNode;
						client.put("nature", eElement.getElementsByTagName("nature").item(0).getTextContent());
						client.put("telephone", eElement.getElementsByTagName("telephone").item(0).getTextContent());
						client.put("adress", eElement.getElementsByTagName("adress").item(0).getTextContent());
						client.put("ville", (long) Integer
								.parseInt(eElement.getElementsByTagName("ville").item(0).getTextContent()));
						client.put("email", eElement.getElementsByTagName("email").item(0).getTextContent());

						if (eElement.getElementsByTagName("nature").item(0).getTextContent().equals("particulier")) {
							System.out.println("mchet cli");
							client.put("prenom", eElement.getElementsByTagName("prenom").item(0).getTextContent());
							client.put("nom", eElement.getElementsByTagName("nom").item(0).getTextContent());
							client.put("annee",
									Integer.parseInt(eElement.getElementsByTagName("annee").item(0).getTextContent()));
							client.put("mois",
									Integer.parseInt(eElement.getElementsByTagName("mois").item(0).getTextContent()));
							client.put("jour",
									Integer.parseInt(eElement.getElementsByTagName("jour").item(0).getTextContent()));
							client.put("lieuNaissance",
									eElement.getElementsByTagName("lieuNaissance").item(0).getTextContent());
							client.put("nationality",
									eElement.getElementsByTagName("nationality").item(0).getTextContent());
							client.put("annee1",
									Integer.parseInt(eElement.getElementsByTagName("annee1").item(0).getTextContent()));
							client.put("mois1",
									Integer.parseInt(eElement.getElementsByTagName("mois1").item(0).getTextContent()));
							client.put("jour1",
									Integer.parseInt(eElement.getElementsByTagName("jour1").item(0).getTextContent()));
							client.put("nomEmployeur",
									eElement.getElementsByTagName("nomEmployeur").item(0).getTextContent());
							client.put("secteurActivite",
									eElement.getElementsByTagName("secteurActivite").item(0).getTextContent());
							client.put("civilite", eElement.getElementsByTagName("civilite").item(0).getTextContent());
							client.put("typeLogement",
									eElement.getElementsByTagName("typeLogement").item(0).getTextContent());
							client.put("profession",
									eElement.getElementsByTagName("profession").item(0).getTextContent());
							client.put("typeContrat",
									eElement.getElementsByTagName("typeContrat").item(0).getTextContent());
							client.put("secteurActiviteEmployeur",
									eElement.getElementsByTagName("secteurActiviteEmployeur").item(0).getTextContent());
							client.put("tailleEmployeur",
									eElement.getElementsByTagName("tailleEmployeur").item(0).getTextContent());

						} else {

							client.put("annee",
									Integer.parseInt(eElement.getElementsByTagName("annee").item(0).getTextContent()));
							client.put("mois",
									Integer.parseInt(eElement.getElementsByTagName("mois").item(0).getTextContent()));
							client.put("jour",
									Integer.parseInt(eElement.getElementsByTagName("jour").item(0).getTextContent()));
							client.put("denominastionSociale",
									eElement.getElementsByTagName("denominastionSociale").item(0).getTextContent());
							client.put("formeJuridique",
									eElement.getElementsByTagName("formeJuridique").item(0).getTextContent());
							client.put("structureJuridique",
									eElement.getElementsByTagName("structureJuridique").item(0).getTextContent());
							client.put("codeAgentEconomique",
									eElement.getElementsByTagName("codeAgentEconomique").item(0).getTextContent());
							client.put("nomContact",
									eElement.getElementsByTagName("nomContact").item(0).getTextContent());
							client.put("prenomContact",
									eElement.getElementsByTagName("prenomContact").item(0).getTextContent());
							client.put("telContact",
									eElement.getElementsByTagName("telContact").item(0).getTextContent());
							client.put("emailContact",
									eElement.getElementsByTagName("emailContact").item(0).getTextContent());

						}

						System.out.println("mchet cli");

					}

					Map<String, Object> demande = new HashMap<String, Object>();

					nlist = doc.getElementsByTagName("demandeFinancement");
					nNode = nlist.item(0);

					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
						Element eElement = (Element) nNode;
						demande.put("delegation", eElement.getElementsByTagName("delegation").item(0).getTextContent());
						demande.put("coutProjet", Double
								.parseDouble(eElement.getElementsByTagName("coutProjet").item(0).getTextContent()));
						demande.put("description",
								eElement.getElementsByTagName("description").item(0).getTextContent());
						demande.put("situationGeoProjet", (long) Integer.parseInt(
								eElement.getElementsByTagName("situationGeoProjet").item(0).getTextContent()));
						demande.put("secteurProjet", (long) Integer
								.parseInt(eElement.getElementsByTagName("secteurProjet").item(0).getTextContent()));
						demande.put("typeFinancement", (long) Integer
								.parseInt(eElement.getElementsByTagName("typeFinancement").item(0).getTextContent()));
						demande.put("categorieProjet", (long) Integer
								.parseInt(eElement.getElementsByTagName("categorieProjet").item(0).getTextContent()));
						System.out.println("mchet demande");

						List<Map<String, Object>> listligne = new ArrayList<Map<String, Object>>();
						NodeList ligne = eElement.getElementsByTagName("lignes");
						nNode = ligne.item(0);
						if (nNode.getNodeType() == Node.ELEMENT_NODE) {
							Element l = (Element) nNode;
							NodeList li = l.getElementsByTagName("ligne");
							for (int z = 0; z < li.getLength(); z++) {
								nNode = li.item(z);
								if (nNode.getNodeType() == Node.ELEMENT_NODE) {
									Element eligne = (Element) nNode;
									Map<String, Object> l1 = new HashMap<String, Object>();
									l1.put("duree", Integer
											.parseInt(eligne.getElementsByTagName("duree").item(0).getTextContent()));
									l1.put("montant", Double.parseDouble(
											eligne.getElementsByTagName("montant").item(0).getTextContent()));
									l1.put("idProduit", Integer.parseInt(
											eligne.getElementsByTagName("idProduit").item(0).getTextContent()));
									l1.put("description",
											eligne.getElementsByTagName("description").item(0).getTextContent());

									System.out.println("mchet ligne");
									listligne.add(l1);
								}
							}
						}

						demande.put("lignes", listligne);

						List<Map<String, Object>> listdoc = new ArrayList<Map<String, Object>>();
						NodeList docs = eElement.getElementsByTagName("docs");
						nNode = docs.item(0);
						System.out.println("mchet doc");
						if (nNode.getNodeType() == Node.ELEMENT_NODE) {
							Element l = (Element) nNode;
							NodeList doc1 = l.getElementsByTagName("doc");
							for (int f = 0; f < doc1.getLength(); f++) {
								Node node = doc1.item(f);
								if (nNode.getNodeType() == Node.ELEMENT_NODE) {
									Element edoc = (Element) node;
									Map<String, Object> d1 = new HashMap<String, Object>();
									d1.put("nom", edoc.getElementsByTagName("nom").item(0).getTextContent());
									d1.put("description",
											edoc.getElementsByTagName("description").item(0).getTextContent());
									d1.put("contenu", edoc.getElementsByTagName("contenu").item(0).getTextContent());
									System.out.println("mchet doc");
									listdoc.add(d1);
								}
							}
						}

						demande.put("doc", listdoc);
					}
					// LISTE COMPTE
					List<Map<String, Object>> compte = new ArrayList<Map<String, Object>>();
					nlist = doc.getElementsByTagName("comptes");
					nNode = nlist.item(0);
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
						Element eElement = (Element) nNode;
						NodeList comptes = eElement.getElementsByTagName("compte");
						for (int j = 0; j < comptes.getLength(); j++) {
							nNode = comptes.item(j);
							System.out.println("node name: " + nNode.getNodeName() + " " + (j + 1));
							if (nNode.getNodeType() == Node.ELEMENT_NODE) {
								Element ecompte = (Element) nNode;
								Map<String, Object> m1 = new HashMap<String, Object>();
								m1.put("numero", ecompte.getElementsByTagName("numero").item(0).getTextContent());
								m1.put("typecompte", Integer
										.parseInt(ecompte.getElementsByTagName("typecompte").item(0).getTextContent()));
								m1.put("solde", Double
										.parseDouble(ecompte.getElementsByTagName("solde").item(0).getTextContent()));
								m1.put("rib",
										Integer.parseInt(ecompte.getElementsByTagName("rib").item(0).getTextContent()));
								m1.put("description",
										(String) ecompte.getElementsByTagName("description").item(0).getTextContent());
								compte.add(m1);

							}
						}
					}

					// NEW RELATION

					newRelation("", "", "ENCOURS", client, demande, compte);
			         String src = "C:\\"+"\\"+"eer\\"+"\\"+"xml\\"+"\\"+contents[i];
			         String dest = "C:\\"+"\\"+"eer\\"+"\\"+"backup\\"+"\\"+contents[i];
			         Files.move(Paths.get(src), Paths.get(dest)); 
					System.out.println("mchet");
					 }
				} else {
					System.out.println("Le répertoire est vide!");
				}
			} else {
				System.out.println("Ce n'est pas un répertoire!");
			}
		} catch (Exception e) {
			System.out.println("ghaltaa");
		}
	}

}
