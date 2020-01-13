package com.lmc.java.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class CalculatorAppTest {
	
	@Test
	public void validTest1() {
		double expectedResult = 2;
		double actualResult = CalculatorApp.calculate(" 10 - ( 2 + 3 * ( 7 - 5 ) ) ");
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void validTest2() {
		double expectedResult = 6.2;
		double actualResult = CalculatorApp.calculate(" 23 - ( 29.3 - 12.5 ) ");
		assertEquals(expectedResult, actualResult);
		
	}
	
	@Test
	public void validTest3() {
		double expectedResult = 37;
		double actualResult = CalculatorApp.calculate(" ( 11.5 + 15.4 ) + 10.1 ");
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void validTest4() {
		double expectedResult = 4;
		double actualResult = CalculatorApp.calculate(" 1 + 1 * 3 ");
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void validTest5() {
		double expectedResult = 34.1;
		double actualResult = CalculatorApp.calculate(" 11.1 + 23 ");
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void validTest6() {
		double expectedResult = 34;
		double actualResult = CalculatorApp.calculate(" 11 + 23 ");
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void validTest7() {
		double expectedResult = 3;
		double actualResult = CalculatorApp.calculate(" 6 / 2 ");
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void validTest8() {
		double expectedResult = 6;
		double actualResult = CalculatorApp.calculate(" 1 + 2 + 3 ");
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void validTest9() {
		double expectedResult = 4;
		double actualResult = CalculatorApp.calculate(" 2 * 2 ");
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void validTest10() {
		double expectedResult = 2;
		double actualResult = CalculatorApp.calculate(" 1 + 1 ");
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void validTest11() {
		double expectedResult = 18;
		double actualResult = CalculatorApp.calculate(" 3 * 5 + 3 ");
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void validTest12() {
		double expectedResult = 24;
		double actualResult = CalculatorApp.calculate(" 3 + 7 * 3 ");
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void validTest13() {
		double expectedResult = 21;
		double actualResult = CalculatorApp.calculate(" 8 + (3 * 5) + 3 - (15 / 3) ");
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void validTest14() {
		double expectedResult = 55;
		double actualResult = CalculatorApp.calculate(" ( 20 / 4 ) * 10 + 5 ");
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void validTest15() {
		double expectedResult = 505;
		double actualResult = CalculatorApp.calculate(" ( ( 20 / 4 ) * 10 ) * 10 + 5 ");
		assertEquals(expectedResult, actualResult);
	}
	

	
	@Test
	public void invalidTest01() {
		assertThrows(RuntimeException.class, ()->CalculatorApp.calculate(" [ 1 + 1 ]"), "Character is not supported: [");
	}
	
	@Test
	public void invalidTest02() {
		assertThrows(RuntimeException.class, ()->CalculatorApp.calculate(" { 1 + 1 ]"), "Character is not supported: {");
	}
	
	

}
