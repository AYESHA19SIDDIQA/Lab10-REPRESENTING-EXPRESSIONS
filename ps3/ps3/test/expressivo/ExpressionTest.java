/* Copyright (c) 2015-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package expressivo;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests for the Expression abstract data type.
 */
public class ExpressionTest {

	@Test
	public void testMultiplicationToString() {
	    Expression mul = new Multiplication(new Literal(2), new Variable("x"));
	    assertEquals("(2.0 * x)", mul.toString());
	}

	@Test
	public void testMultiplicationEquality() {
	    Expression mul1 = new Multiplication(new Literal(4), new Variable("y"));
	    Expression mul2 = new Multiplication(new Literal(4), new Variable("y"));
	    assertEquals(mul1, mul2);
	}

	@Test
	public void testMultiplicationInequality() {
	    Expression mul1 = new Multiplication(new Variable("x"), new Literal(5));
	    Expression mul2 = new Multiplication(new Literal(5), new Variable("x"));
	    assertNotEquals(mul1, mul2); // Order matters
	}

	@Test
	public void testMultiplicationHashCodeEquality() {
	    Expression mul1 = new Multiplication(new Variable("z"), new Literal(2));
	    Expression mul2 = new Multiplication(new Variable("z"), new Literal(2));
	    assertEquals(mul1.hashCode(), mul2.hashCode());
	}

	@Test(expected = NullPointerException.class)
	public void testMultiplicationWithNullOperand() {
	    new Multiplication(null, new Variable("a")); // Should throw NullPointerException
	}

	@Test
	public void testAdditionToString() {
	    Expression add = new Addition(new Literal(3), new Variable("y"));
	    assertEquals("(3.0 + y)", add.toString());
	}

	@Test
	public void testAdditionEquality() {
	    Expression add1 = new Addition(new Literal(3), new Variable("x"));
	    Expression add2 = new Addition(new Literal(3), new Variable("x"));
	    assertEquals(add1, add2);
	}

	@Test
	public void testAdditionInequality() {
	    Expression add1 = new Addition(new Literal(3), new Variable("x"));
	    Expression add2 = new Addition(new Variable("x"), new Literal(3));
	    assertNotEquals(add1, add2); // Order matters
	}

	@Test
	public void testAdditionHashCodeEquality() {
	    Expression add1 = new Addition(new Literal(1), new Variable("z"));
	    Expression add2 = new Addition(new Literal(1), new Variable("z"));
	    assertEquals(add1.hashCode(), add2.hashCode());
	}

	@Test(expected = NullPointerException.class)
	public void testAdditionWithNullOperand() {
	    new Addition(new Literal(1), null); // Should throw NullPointerException
	}
	@Test
	public void testLiteralToString() {
	    Expression lit = new Literal(5.5);
	    assertEquals("5.5", lit.toString());
	}

	@Test
	public void testLiteralEquality() {
	    Expression lit1 = new Literal(10);
	    Expression lit2 = new Literal(10.0);
	    assertEquals(lit1, lit2); // Integer and double comparison
	}

	@Test
	public void testLiteralInequality() {
	    Expression lit1 = new Literal(3.14);
	    Expression lit2 = new Literal(3.15);
	    assertNotEquals(lit1, lit2);
	}

	@Test
	public void testLiteralHashCodeEquality() {
	    Expression lit1 = new Literal(42);
	    Expression lit2 = new Literal(42.0);
	    assertEquals(lit1.hashCode(), lit2.hashCode());
	}

	@Test(expected = NullPointerException.class)
	public void testLiteralNullValue() {
	    new Literal(Double.valueOf(null)); // Should throw NullPointerException
	}
	@Test
	public void testVariableToString() {
	    Expression var = new Variable("x");
	    assertEquals("x", var.toString());
	}

	@Test
	public void testVariableEquality() {
	    Expression var1 = new Variable("z");
	    Expression var2 = new Variable("z");
	    assertEquals(var1, var2);
	}

	@Test
	public void testVariableInequality() {
	    Expression var1 = new Variable("a");
	    Expression var2 = new Variable("b");
	    assertNotEquals(var1, var2);
	}

	@Test
	public void testVariableHashCodeEquality() {
	    Expression var1 = new Variable("x");
	    Expression var2 = new Variable("x");
	    assertEquals(var1.hashCode(), var2.hashCode());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testVariableInvalidName() {
	    new Variable("123"); // Variable name must be alphabetic
	}

}
