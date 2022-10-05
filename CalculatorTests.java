import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculatorTests 
{

	@Test
	public void testZero() 
	{
		char a = '0';
		String str = String.valueOf(a);
		assertEquals("Test with input: 0", 0, Calculator.calculate(str));
		
		String str0 = "00000";
		assertEquals("Test with input: 00000", 0, Calculator.calculate(str0));
		
		str0 = "10";
		assertEquals("Test with input: 10", 10, Calculator.calculate(str0));
		
		str0 = "1000";
		assertEquals("Test with input: 1000", 1000, Calculator.calculate(str0));
	}
	
	@Test
	public void testNumbers() 
	{
		String str = "5";
		assertEquals("Test with input: 5", 5, Calculator.calculate(str));
		
		str = "46";
		assertEquals("Test with input: 46", 46, Calculator.calculate(str));
		
		str = "259";
		assertEquals("Test with input: 259", 259, Calculator.calculate(str));
		
		str = "16782";
		assertEquals("Test with input: 16782", 16782, Calculator.calculate(str));
	}
}
