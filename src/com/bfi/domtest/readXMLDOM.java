package com.bfi.domtest;
import java.io.*; 
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
public class readXMLDOM {

	public static void main(String[] args) {
		try {
			
			File xmlDoc=new File("students.xml"); 
			DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
			DocumentBuilder db= dbf.newDocumentBuilder();
			Document doc=db.parse(xmlDoc);
			
			//Read Root Element
			System.out.println("root element:"+doc.getDocumentElement().getNodeName());
			
			//read array
			NodeList nlist=doc.getElementsByTagName("student");
			for(int i=0; i<nlist.getLength();i++) {
				Node nNode=nlist.item(i);
				System.out.println("node name: " +nNode.getNodeName()+" " +(i+1));
				 if(nNode.getNodeType()==Node.ELEMENT_NODE) 
				 {
					 Element eElement=(Element) nNode;
					 System.out.println("Student ID#: "+eElement.getAttribute("id"));
					 System.out.println("Student first name"+eElement.getElementsByTagName("firstname").item(0).getTextContent());
					 System.out.println("Student last name"+eElement.getElementsByTagName("lastname").item(0).getTextContent());
					 System.out.println("Student score"+(Integer.parseInt(eElement.getElementsByTagName("score").item(0).getTextContent())+1));
					 NodeList mat=eElement.getElementsByTagName("matieres");
					 for(int j=0; j<mat.getLength();j++) {
							nNode=mat.item(j);
							 if(nNode.getNodeType()==Node.ELEMENT_NODE) 
							 {
								 eElement=(Element) nNode;
								 System.out.println("nom:  "+eElement.getElementsByTagName("nom").item(0).getTextContent());
								 
								 
							 }
						}
				 }
			}
			
		}
		catch(Exception e) {System.out.println("erreur");}
		
		
	}

}
