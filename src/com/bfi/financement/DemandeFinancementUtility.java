package com.bfi.financement;
import java.util.*;

import javax.persistence.*;

public class DemandeFinancementUtility {
		
	public static DemandeFinancement newdemande(String delegation, double coutProjet,String description,
			long situationGeoProjet, long secteurProjet,
			long typeFinancement, long categorieProjet,
			List<Map<String,Object>> lignes,List<Map<String,Object>> doc) {
		DemandeFinancement demande=null;
		try {
	          EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_first");
	  EntityManager em = emf.createEntityManager();
	  EntityTransaction transac = em.getTransaction();

	  try {
	  transac.begin();
	  CategorieProjet c= em.find(CategorieProjet.class, categorieProjet);
	  SituationGeographiqueProjet sit= em.find(SituationGeographiqueProjet.class, situationGeoProjet);
	  SecteurProjet sect=em.find(SecteurProjet.class, secteurProjet);
	  TypeDeFinancement type=em.find(TypeDeFinancement.class, typeFinancement);
	  
	   
	  demande=new DemandeFinancement(delegation,coutProjet,description,sit,sect,type,c);
		 
	  for (Map<String, Object> map : lignes) {
		  int duree=(int) map.get("duree");
		  double montant = (double) map.get("montant");
		  int prod=(int)map.get("idProduit");
		  Produit p=em.find(Produit.class,(long)prod);
		  String desc=(String)map.get("description");
		  LigneDeFinancement l= new LigneDeFinancement(duree, montant, desc,p);
		  demande.addLigne(l);
	}
	  for(Map<String,Object>map :doc) {
		  String nom=(String)map.get("nom");
		  String desc=(String)map.get("description");
		  byte[] contenu= Base64.getDecoder().decode((String)map.get("contenu"));	
		  DocumentsFinancement d=new DocumentsFinancement(nom,desc,contenu);
		  demande.addDoc(d);
	  }
	  
	  em.persist(demande);
	   
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
		return demande;
	}
	public static void main(String []args) {
		Map<String,Object> l1=new HashMap<String,Object>(); 
		l1.put("duree", 2);
		l1.put("montant", 24.5);
		l1.put("idProduit", 1);
		List<Map<String,Object>>listligne=new ArrayList<Map<String,Object>>();
		listligne.add(l1);
		
		
		Map<String,Object> d1=new HashMap<String,Object>(); 
		d1.put("nom", "justificatif");
		d1.put("description", "....");
		d1.put("obligatoire", false);
		List<Map<String,Object>>listdoc=new ArrayList<Map<String,Object>>();
		listdoc.add(d1);
		
		newdemande("sousse",27500.0,"description1",1,1,1,1,listligne,listdoc);
	}
}
