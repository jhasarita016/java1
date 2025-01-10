package com.encoding;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class IndianArmy {
	
	private String allChar ="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789: ";
		
	private	Map<String, String> encodingMap = new HashMap<>();
	private	Map<String, String> decodingMap = new HashMap<>(); 
		
	public IndianArmy() {
		for(int i=0;i<allChar.length();i++) {
			encodingMap.put("" + allChar.charAt(i), i < 10 ? "0" + i : ""+i);
			decodingMap.put(i < 10 ? "0" + i : ""+i, "" + allChar.charAt(i));
		}
	}
	
	public static void main(String[] args) throws IOException{
		IndianArmy ia =new IndianArmy();
//		System.out.println(ia.chartocode);
	//	String encodedStr = ia.encode("Attack Kargil at 6:05 PM");
		String encodedStr = ia.encode("CAB");
		System.out.println(encodedStr);
		System.out.println(ia.deCode(encodedStr));
		
		File f1 = new File("messages.txt");
		FileWriter fw1 = new FileWriter("messages_enc.txt");			
		Scanner sc1 = new Scanner(f1);
		String s1 ;
		
		for (int i =0;i<2;i++) {
			s1 =sc1.nextLine();
			encodedStr = ia.encode(s1);
		    fw1.write(encodedStr);	
		    fw1.write("\n");
		}
		fw1.close();
		
		
		
	}
	
	
	 public String encode(String token) {
		 
		 StringBuilder encodedStr = new StringBuilder();
		 
		 for(int i = 0; i < token.length(); i++) {
			 encodedStr.append(encodingMap.get("" + token.charAt(i)));
		 }
		 
		 return encodedStr.toString();
	 }

	 public String deCode(String encodedToken) {
		 StringBuilder decodedStr = new StringBuilder();
		 
		 for(int i = 0; i < encodedToken.length(); i = i+2) {
			 decodedStr.append(decodingMap.get("" + encodedToken.charAt(i) + encodedToken.charAt(i + 1)));
		 }
		 
		 return decodedStr.toString();
	 }
}
