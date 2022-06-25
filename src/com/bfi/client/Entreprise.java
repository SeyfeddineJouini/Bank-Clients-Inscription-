package com.bfi.client;

import javax.persistence.*;
import java.util.*;
@Entity
@Table(name="entreprise")
public class Entreprise extends Client {
	
	private String denominastionSociale;
	
	private Date dateCreationEntite;
	
	private String descriptionActivite;
	
	@Enumerated(EnumType.STRING)
	private FormeJuridique formeJuridique;
	
	@Enumerated(EnumType.STRING)
	private StructureJuridique structureJuridique;
	
	@Enumerated(EnumType.STRING)
	private CodeAgentEconomique codeAgentEconomique;
	
	private String nomContact;
	
	private String prenomContact;
	
	private String telContact;
	
	private String emailContact;
	
	public Entreprise() {}

	public Entreprise(String adress,Ville ville,String denominastionSociale,String telephone, 
			String email ,String descriptionActivite, FormeJuridique formeJuridique,
			StructureJuridique structureJuridique, CodeAgentEconomique codeAgentEconomique,
			String nomContact, String prenomContact, String telContact,String emailContact) {
		super(adress, telephone, email,ville);
		this.denominastionSociale = denominastionSociale;
		this.dateCreationEntite = new Date();
		this.descriptionActivite = descriptionActivite;
		this.formeJuridique = formeJuridique;
		this.structureJuridique = structureJuridique;
		this.codeAgentEconomique = codeAgentEconomique;
		this.nomContact = nomContact;
		this.prenomContact = prenomContact;
		this.telContact = telContact;
		this.emailContact=emailContact;
	}
	
	public String getDenominastionSociale() {
		return denominastionSociale;
	}

	public void setDenominastionSociale(String denominastionSociale) {
		this.denominastionSociale = denominastionSociale;
	}

	public Date getDateCreationEntite() {
		return dateCreationEntite;
	}

	public void setDateCreationEntite(int annee,int mois,int jour) {

		Calendar c= new GregorianCalendar(annee, mois-1, jour);
		this.dateCreationEntite = c.getTime();
	}



	public String getDescriptionActivite() {
		return descriptionActivite;
	}

	public void setDescriptionActivite(String descriptionActivite) {
		this.descriptionActivite = descriptionActivite;
	}

	public FormeJuridique getFormeJuridique() {
		return formeJuridique;
	}

	public void setFormeJuridique(FormeJuridique formeJuridique) {
		this.formeJuridique = formeJuridique;
	}

	public StructureJuridique getStructureJuridique() {
		return structureJuridique;
	}

	public void setStructureJuridique(StructureJuridique structureJuridique) {
		this.structureJuridique = structureJuridique;
	}

	public CodeAgentEconomique getCodeAgentEconomique() {
		return codeAgentEconomique;
	}

	public void setCodeAgentEconomique(CodeAgentEconomique codeAgentEconomique) {
		this.codeAgentEconomique = codeAgentEconomique;
	}

	public String getNomContact() {
		return nomContact;
	}

	public void setNomContact(String nomContact) {
		this.nomContact = nomContact;
	}

	public String getPrenomContact() {
		return prenomContact;
	}

	public void setPrenomContact(String prenomContact) {
		this.prenomContact = prenomContact;
	}

	public String getTelContact() {
		return telContact;
	}

	public void setTelContact(String telContact) {
		this.telContact = telContact;
	}

	public String getEmailContact() {
		return emailContact;
	}

	public void setEmailContact(String emailContact) {
		this.emailContact = emailContact;
	}

	@Override
	public String toString() {
		return super.toString()+"Entreprise [denominastionSociale=" + denominastionSociale + ", dateCreationEntite=" + dateCreationEntite
				+ ", descriptionActivite=" + descriptionActivite + ", formeJuridique=" + formeJuridique
				+ ", structureJuridique=" + structureJuridique + ", codeAgentEconomique=" + codeAgentEconomique
				+ ", nomContact=" + nomContact + ", prenomContact=" + prenomContact + ", telContact=" + telContact
				+ ", emailContact=" + emailContact + "]";
	}
		
	
	
	
	
	

}