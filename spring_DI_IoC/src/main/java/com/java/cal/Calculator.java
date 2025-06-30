package com.java.cal;

import com.java.operator.Operator;

public class Calculator {

	private Operator sum;
	private Operator minus;
	private Operator multi;
	private Operator div;
	public void setSum(Operator sum) {
		this.sum = sum;
	}
	public void setMinus(Operator minus) {
		this.minus = minus;
	}
	public void setMulti(Operator multi) {
		this.multi = multi;
	}
	public void setDiv(Operator div) {
		this.div = div;
	}
	
	public int plus(int a, int b) {
		return sum.op(a, b);
	}
	
	public int minus(int a, int b) {
		return minus.op(a, b);
	}
	
	public int multi(int a, int b) {
		return multi.op(a, b);
	}
	
	public int div(int a, int b) {
		return div.op(a, b);
	}
}








