package com.java.string;

public class String_EX01 {

	public static void main(String[] args) {
		String str = "abcdefg";
		
		String temp = str.substring(1,4);
		
		System.out.println(str);
		System.out.println(temp);
		
		
		String str2 = "123abc123abc";
		System.out.println(str2.indexOf("123"));
		System.out.println(str2.lastIndexOf("123"));
		
		
		String filename1 ="ttta.aabbbb.jpg";
		String filename2 ="tttaa.abbbb.png";
		
		System.out.println(filename1.substring(filename1.lastIndexOf(".")+1));
	
		String str3 = "aaa";
		String str4 = "ccc";
		System.out.println(str3.compareTo(str4));
		
		String str5 = "123456789";
		System.out.println(str5.replace("456", "abc"));
	}

}
