import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculatorTests 
{
	@Test
	public void testIsValidExpression()
	{
		String test = "5+6";
		assertEquals("Can Handle 2 Numbers?", true, Calculator.isValidExpression(test));
		
		test = "12435+34569-12345*10+50";
		assertEquals("Can Handle multiple Numbers?", true, Calculator.isValidExpression(test));
		
		test = "+2*3";
		assertEquals("Equation starting with sign, invalid", false, Calculator.isValidExpression(test));
		
		test = "2+3-";
		assertEquals("Equation ending with sign, invalid", false, Calculator.isValidExpression(test));
		
		test = "SWENG";
		assertEquals("Non mathematical expression input", false, Calculator.isValidExpression(test));
		
		test = "SWENG SWENG";
		assertEquals("Non mathematical expression input", false, Calculator.isValidExpression(test));
		
		test = "6++4";
		assertEquals("Expression with 2 operators in a row", false, Calculator.isValidExpression(test));
		
		test = "3+6*t";
		assertEquals("Mathematical expression with a non-number", false, Calculator.isValidExpression(test));
		
		test = "5 + 6 - 8 * 10";
		assertEquals("Mathematical expression with a spaces between numbers and operators", true, Calculator.isValidExpression(test));
		
		test = "0";
		assertEquals("Test for 0", true, Calculator.isValidExpression(test));
		
		test = "0000";
		assertEquals("Test for 0000", true, Calculator.isValidExpression(test));
	}
	
	@Test
	public void testIsOperator()
	{
		assertEquals("Testing add operator", true, Calculator.isOperator('+'));
		assertEquals("Testing subtract operator", true, Calculator.isOperator('-'));
		assertEquals("Testing multiply operator", true, Calculator.isOperator('*'));
		assertEquals("Testing ivalid character", false, Calculator.isOperator('?'));
		assertEquals("Testing invalid number", false, Calculator.isOperator('0'));
	}
	
	@Test 
	public void testOpPrecedence()
	{
		assertEquals("Testing add operator", 1, Calculator.opPrecedence('+'));
		assertEquals("Testing subtract operator", 1, Calculator.opPrecedence('-'));
		assertEquals("Testing multiply operator", 2, Calculator.opPrecedence('*'));
		assertEquals("Testing ivalid character", 0, Calculator.opPrecedence('?'));
		assertEquals("Testing invalid number", 0, Calculator.opPrecedence('0'));
	}
	
	@Test 
	public void testCalculate() 
	{
		String test = "12435+34569-12345*10+50";
		assertEquals("test example input", -76396, Calculator.calculate(test));
		
		test = "1+1";
		assertEquals("Calculate test addition", 2, Calculator.calculate(test));
		
		test = "1-1";
		assertEquals("Calculate test subtraction", 0, Calculator.calculate(test));
		
		test = "1*1";
		assertEquals("Calculate test multiplication", 1, Calculator.calculate(test));
		
		test = "1+0";
		assertEquals("Calculate test addition with 0", 1, Calculator.calculate(test));
		
		test = "1-0";
		assertEquals("Calculate test subtraction with 0", 1, Calculator.calculate(test));
		
		test = "1*0";
		assertEquals("Calculate test multiplication with 0", 0, Calculator.calculate(test));
		
		test = "5-5+0*5";
		assertEquals("Calculate test multiply with precendence", 0, Calculator.calculate(test));
	}
}