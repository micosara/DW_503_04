package com.java.array;

public class Array_EX {

	public static void main(String[] args) {
		int[] arr = new int[45];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}

		for (int i = 0; i < arr.length * 3; i++) {
			int target = (int)(Math.random()*44+1);
			int temp = -1;
			
			temp = arr[0];
			arr[0] = arr[target];
			arr[target] = temp;
		}

		for (int i = 0; i < 6; i++) {
			System.out.print(arr[i]+" ");
		}

	}

}
