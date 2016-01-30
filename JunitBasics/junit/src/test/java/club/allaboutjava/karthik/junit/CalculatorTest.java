package club.allaboutjava.karthik.junit;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * <p>
 * Test class for Calculator
 * </p>
 * 
 * @author Karthik Arun (karthikarun@outlook.com)
 */
public class CalculatorTest {
	/*
	 * Example to demonstrate successful assertEquals.
	 */
	@Test
	public void testAddMethod() {
		int a = 3;
		int b = 4;
		Calculator calculator = new Calculator();
		assertEquals(calculator.add(a, b), 7);
	}

	/*
	 * Example to demonstrate failure assertEquals.
	 */
	@Test
	public void testSubtractMethodIncorrectComparison() {
		int a = 3;
		int b = 4;
		Calculator calculator = new Calculator();
		assertEquals(calculator.subtract(b, a), 2);
	}
	
	@Test
	public void testSubtractMethodCorrectComparison() {
		int a = 3;
		int b = 4;
		Calculator calculator = new Calculator();
		assertEquals(calculator.subtract(b, a), 1);
	}
}
