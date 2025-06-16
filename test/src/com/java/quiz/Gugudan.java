package com.java.quiz;

public class Gugudan {
	int startDan = 2, maxDan = 9;
	int startGop = 1, maxGop = 9;
	String result = "";

	public Gugudan() {
	}

	public Gugudan(int startDan, int maxDan, int startGop, int maxGop) {
		this.startDan = startDan;
		this.maxDan = maxDan;
		this.startGop = startGop;
		this.maxGop = maxGop;
	}

	public void gugudan() {
		for (int dan = startDan; dan < maxDan + 1; dan++) {
			result += dan + "´Ü\n";
			for (int gop = startGop; gop < maxGop + 1; gop++) {
				result += dan + " * " + gop + " = " + (dan * gop) + "\n";
			}
			result += "\n";
		}
	}

	public void print() {
		System.out.println(result);
	}

	
}
