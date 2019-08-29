package com.example.stockspring.model;

public class CompareCompany {

	private int c1;
	private int c2;
	public int getC1() {
		return c1;
	}
	public void setC1(int c1) {
		this.c1 = c1;
	}
	public int getC2() {
		return c2;
	}
	public void setC2(int c2) {
		this.c2 = c2;
	}
	public CompareCompany(int c1, int c2) {
		super();
		this.c1 = c1;
		this.c2 = c2;
	}
	public CompareCompany() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CompareCompany [c1=" + c1 + ", c2=" + c2 + "]";
	}
	
}
