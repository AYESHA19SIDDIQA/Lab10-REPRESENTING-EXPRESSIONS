package expressivo;

/**
 * An immutable data type representing a polynomial expression of:
 *   + and *
 *   nonnegative integers and floating-point numbers
 *   variables (case-sensitive nonempty strings of letters)
 * 
 * <p>This is an abstract data type (ADT) interface with multiple concrete
 * implementations for different types of expressions.
 * 
 * Datatype definition:
 * Expression = Literal(value: double) 
 *            + Variable(name: String)
 *            + Addition(left: Expression, right: Expression)
 *            + Multiplication(left: Expression, right: Expression)
 * 
 * Implementations of this interface must define:
 * - Recursive `toString()` to represent the expression as a valid string.
 * - Recursive `equals()` and `hashCode()` to ensure structural equality.
 */
public interface Expression {

    /**
     * Parse an expression from a string.
     * @param input a valid expression string as defined in the problem set.
     *              Examples: "x", "3.14", "x + 2", "(x + y) * 3"
     * @return the abstract syntax tree (AST) representing the expression
     * @throws IllegalArgumentException if the input expression is invalid
     */
    public static Expression parse(String input) {
        // This should invoke a parser implementation that converts input into an Expression AST.
        throw new RuntimeException("parse() is not yet implemented.");
    }

    /**
     * @return a parsable representation of this expression, such that
     * for all e:Expression, e.equals(Expression.parse(e.toString())).
     */
    @Override
    String toString();

    /**
     * Determine structural equality between two expressions.
     * @param thatObject the object to compare with
     * @return true if this expression is structurally equal to thatObject
     */
    @Override
    boolean equals(Object thatObject);

    /**
     * @return a hash code value consistent with the equals() definition of structural
     * equality, such that for all e1,e2:Expression,
     *     e1.equals(e2) implies e1.hashCode() == e2.hashCode()
     */
    @Override
    int hashCode();
}
