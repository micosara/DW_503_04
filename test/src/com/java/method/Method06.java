package com.java.method;

public class Method06 {
   public static int sum(int x, int y) {
       return (x + y);
   }
 
   public static int sum(int x, int y, int z) {
       return (x + y + z);
   }
 
   public static double sum(double x, double y) {
       return (x + y);
   }
 
   public static void main(String args[]) {
       System.out.println("sum(10, 20)의 값 : " + sum(10, 20));
       System.out.println("sum(10, 20, 30)의 값 : " + sum(10, 20, 30));
       System.out.println("sum(10.5, 20.5)의 값 : "+ sum(10.5, 20.5));  
   }
}