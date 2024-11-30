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
	public void testToString() {
	    Expression expr1 = new Literal(5);
	    assertEquals("5.0", expr1.toString());

	    Expression expr2 = new Variable("x");
	    assertEquals("x", expr2.toString());

	    Expression expr3 = new Addition(new Literal(3), new Variable("y"));
	    assertEquals("(3.0 + y)", expr3.toString());

	    Expression expr4 = new Multiplication(expr3, new Literal(2));
	    assertEquals("((3.0 + y) * 2.0)", expr4.toString());
	}
	@Test
	public void testEquals() {
	    Expression lit1 = new Literal(5);
	    Expression lit2 = new Literal(5.0);
	    assertEquals(lit1, lit2);

	    Expression var1 = new Variable("x");
	    Expression var2 = new Variable("x");
	    Expression var3 = new Variable("y");
	    assertEquals(var1, var2);
	    assertNotEquals(var1, var3);

	    Expression add1 = new Addition(new Literal(1), new Variable("x"));
	    Expression add2 = new Addition(new Literal(1), new Variable("x"));
	    Expression add3 = new Addition(new Variable("x"), new Literal(1));
	    assertEquals(add1, add2);
	    assertNotEquals(add1, add3);
	}
	@Test
	public void testHashCode() {
	    Expression expr1 = new Addition(new Literal(1), new Variable("x"));
	    Expression expr2 = new Addition(new Literal(1), new Variable("x"));
	    assertEquals(expr1.hashCode(), expr2.hashCode());

	    Expression expr3 = new Addition(new Variable("x"), new Literal(1));
	    assertNotEquals(expr1.hashCode(), expr3.hashCode());
	}

    
}
