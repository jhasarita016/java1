package com.encoding;

import java.util.HashMap;
import java.util.Map;

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
	
	public static void main(String[] args) {
		IndianArmy ia =new IndianArmy();
//		System.out.println(ia.chartocode);
	//	String encodedStr = ia.encode("Attack Kargil at 6:05 PM");
		String encodedStr = ia.encode("CAB");
		System.out.println(encodedStr);
		System.out.println(ia.deCode(encodedStr));
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
