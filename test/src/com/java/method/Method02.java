package com.java.method;

public class Method02 {
   public static int div( ) {        
      int a = 10, b = 5;
      int result = a / b;
      
      return result;
   } 
   public static void main(String[] args) {   
     int num = div(); 
     System.out.println(num);   
   }
}