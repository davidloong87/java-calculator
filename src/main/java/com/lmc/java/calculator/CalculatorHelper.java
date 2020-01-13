package com.lmc.java.calculator;

import java.text.DecimalFormat;

public class CalculatorHelper {
	public static final DecimalFormat df3 = new DecimalFormat("#.###");
	private String sumString;
	private int position = -1;
	private int charIdx = 0;

	public CalculatorHelper(String sumString) {
		// automatically remove all empty space when passing in expression string
		this.sumString = removeEmptyString(sumString);
		//start moving char
		moveToNextChar();
	}
	
	public double performCalculation() {
		double result = performCalculationWithBracketResult();
		return Double.valueOf(df3.format(performMathOperation(result, getChar())));
	}

	private double performCalculationWithBracketResult() {
		double result = handleCalculationByBracket();
		return performMathOperation(result, getChar());
	}

	// remove emptyString
	private String removeEmptyString(String x) {
		return x.replace(" ", "");
	}

	// move to next character
	private void moveToNextChar() {
		position++;
		if(this.position < this.sumString.length()) {
			this.charIdx = this.sumString.charAt(this.position);
		}else {
			this.charIdx = -1;
		}
	}

	// calculate result with bracket
	private double handleCalculationByBracket() {
		double result;
		int startPosition = this.position;

		// calculate for number in bracket
		//track start bracket
		if (getChar() == '(') { 
			moveToNextChar();
			result = performCalculation();
			//track end bracket
			if (getChar() == ')') {
				moveToNextChar();
			}
		}
		// capture double integer
		else if ((charIdx >= '0' && charIdx <= '9') || charIdx == '.') {
			while ((charIdx >= '0' && charIdx <= '9') || charIdx == '.') {
				moveToNextChar();
			}
			String captureStr = "";
			try {
				captureStr = sumString.substring(startPosition, this.position);
				result = Double.parseDouble(captureStr);
			}catch(NumberFormatException e) {
				throw new NumberFormatException("Parse fail: " + captureStr);
			}
			
		}
		// throw exception when charater is not supported
		else {
			throw new RuntimeException("Character is not supported: " + getChar());
		}

		return result;
	}

	// calculate result with mathOperator
	private double performMathOperation(double result, char mathOperator) {
		moveToNextChar();
		switch (mathOperator) {
		case '+':
			return result += performCalculationWithBracketResult();
		case '-':
			return result -= performCalculationWithBracketResult();
		case '*':
			return result *= handleCalculationByBracket();
		case '/':
			return result /= handleCalculationByBracket();
		default :
			return result;
		}
	}
	
	private char getChar() {
		return (char) this.charIdx;
	}

}
