package com.bfi.domtest.base64;

import java.io.*;
import java.nio.file.*;
import java.util.Base64;
import java.util.Scanner;
import java.util.stream.Stream;

public class utility {
//		public static void main(String[]args) throws Exception {
//			simpleEncodingAndDecoding();
//			
//			
//			
//		}
//
//		private static void simpleEncodingAndDecoding() throws UnsupportedEncodingException {
//			final String textData="select 'drop sequence ' || sequence_name || ';' from user_sequences; ";
//			String encodedText = Base64.getEncoder().encodeToString(textData.getBytes("UTF-8"));
//			System.out.println(encodedText);
//			
//			byte[] decodedArr=Base64.getDecoder().decode(encodedText);			
//			String decodedText = new String(decodedArr, "UTF-8");
//			System.out.println(decodedText);	
//		}

//	public static void main(String[] args) {
//		File file = new File("C:\\eer\\xml");
//		if (file.isDirectory()) {
//			if (file.list().length > 0) {
//				System.out.println("Le répertoire n'est pas vide!");
//				
//				}
//			} else {
//				System.out.println("Le répertoire est vide!");
//			}
//		} else {
//			System.out.println("Ce n'est pas un répertoire!");
//		}
//	}
//	public static void main(String args[]) throws IOException {
//	      //Creating a File object for directory
//	      File directoryPath = new File("C:\\eer\\xml");
//	      //List of all files and directories
//	      String contents[] = directoryPath.list();
//	      System.out.println("List of files and directories in the specified directory:");
//	      for(int i=0; i<contents.length; i++) {
//	         System.out.println("C:\\"+"\\"+"eer\\"+"\\"+"xml\\"+"\\"+contents[i]);
//	      }
//	   }
//	public static void main(String [] args) throws IOException {
//	 String fileName = "C:\\Users\\REVENTON404\\Desktop\\paiement sonede\\recu rue torkia.pdf";
//     Scanner scan = new Scanner(new File(fileName));
//     while(scan.hasNextLine()){
//         String line = scan.nextLine();
//         System.out.println(line);
//     }
//}
	 public static void main(String[] args) {
	        String file = "C:\\Users\\REVENTON404\\Desktop\\syntaxe utile\\delete seq & tables.txt";
	        try(BufferedReader br = new BufferedReader(new FileReader(file))) 
	        {
	            String line;
	            while ((line = br.readLine()) != null) {
	            	String encodedText = Base64.getEncoder().encodeToString(line.getBytes());
	    			System.out.println(encodedText);
	            }
	        }
	        catch (IOException e) {
	            System.out.println("An error occurred.");
	            e.printStackTrace();
	        }
	    }

}
