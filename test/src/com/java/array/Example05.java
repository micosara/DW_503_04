package com.java.array;

public class Example05 {
    public static void main(String[] args) {
        String s1 = "Java";
        String s2 = "Java";
        String s3 = new String("Java");
        String s4 = new String("Java");

        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s3 == s4);
        
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
        
        System.out.println(s1.equals(s4));
        System.out.println(s1.equals(s4));
        System.out.println(s3.equals(s4));
        
    }
}