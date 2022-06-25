package com.bfi.compte;

import java.util.*;

import javax.persistence.*;

public class CompteUtility {

	public static List<Compte> newComptes(List<Map<String, Object>> liste) {
		List<Compte> compte_list = new ArrayList<Compte>();
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_first");
			EntityManager em = emf.createEntityManager();
			EntityTransaction transac = em.getTransaction();

			try {
				transac.begin();

				for (Map<String, Object> map : liste) {
					double solde = (double) map.get("solde");
					String num = (String) map.get("numero");
					int rib = (int) map.get("rib");

					String desc = (String) map.get("description");
					int type = (int) map.get("typecompte");
					if (type < 7 && type > 0) {
						TypeCompte t = em.find(TypeCompte.class, (long) type);
						Compte c = new Compte(solde, num, rib, desc, t);
						em.persist(c);
						compte_list.add(c);
					}
				}

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

		return compte_list;
	}

	public static void main(String[] args) {

		List<Map<String, Object>> liste = new ArrayList<Map<String, Object>>();
		Map<String, Object> m1 = new HashMap<String, Object>();
		m1.put("numero", "777");
		m1.put("typecompte", 3);
		m1.put("solde", 50.886);
		m1.put("rib", 122);
		m1.put("description", "m1");
		Map<String, Object> m2 = new HashMap<String, Object>();
		m2.put("numero", "888");
		m2.put("typecompte", 2);
		m2.put("solde", 86.2);
		m2.put("rib", 502);
		m1.put("description", "m2");
		Map<String, Object> m3 = new HashMap<String, Object>();
		m3.put("numero", "999");
		m3.put("typecompte", 6);
		m3.put("solde", 25.32);
		m3.put("rib", 886);
		m1.put("description", "m3");
		liste.add(m1);
		liste.add(m2);
		liste.add(m3);

		newComptes(liste);

	}

}
