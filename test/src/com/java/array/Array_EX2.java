package com.java.array;

public class Array_EX2 {

	public static void main(String[] args) {

		int value = 1;
		int[][] result = new int[3][3];

		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				result[i][j] = value;
				value++;
			}
		}

		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				System.out.print(result[i][j]+ " ");
			}
			System.out.println();
		}
	}

}
