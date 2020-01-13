package com.lmc.java.calculator;



public class CalculatorApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String sum = " 3 * 5 + 3";
		System.out.println(calculate(sum));
		
		sum = " 3 + 7 * 3";
		System.out.println(calculate(sum));
		
		 sum = " 10 - ( 2 + 3 * ( 7 - 5 ) ) ";
		System.out.println(calculate(sum));
		
		sum = " 1 + 1 * 3";
		System.out.println(calculate(sum));
		
		sum = " ( 11.5 + 15.4 ) + 10.1 ";
		System.out.println(calculate(sum));
		
		
		sum = " 23 - ( 29.3 - 12.5 ) ";
		System.out.println(calculate(sum));
		
		sum = " 11.1 + 23 ";
		System.out.println(calculate(sum));
	}
	
	public static double calculate(String sum) {
		return new CalculatorHelper(sum).performCalculation();
	}

}
