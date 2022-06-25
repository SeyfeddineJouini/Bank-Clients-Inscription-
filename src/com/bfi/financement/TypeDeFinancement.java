package com.bfi.financement;
import javax.persistence.*;

@Entity
@Table(name = "typeFinancement")
@SequenceGenerator(name = "typefinancement_seq",allocationSize = 1)
public class TypeDeFinancement {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "typefinancement_seq")	
	private long idType;
	
	private String type;
	
	public TypeDeFinancement() {}

		
	public TypeDeFinancement(String type) {
		 
		this.type = type;
	}


	public long getIdType() {
		return idType;
	}

	public void setIdType(int idType) {
		this.idType = idType;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}


	@Override
	public String toString() {
		return "TypeDeFinancement [idType=" + idType + ", type=" + type + "]";
	}
	
}
