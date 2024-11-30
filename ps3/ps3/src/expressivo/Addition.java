package expressivo;

import java.util.Objects;

/**
 * Represents an addition operation in an expression.
 * Immutable class.
 */
public class Addition implements Expression {
    private final Expression left;  // the left operand
    private final Expression right; // the right operand

    /**
     * Creates an addition expression.
     * @param left the left operand
     * @param right the right operand
     */
    public Addition(Expression left, Expression right) {
        this.left = Objects.requireNonNull(left, "Left operand must not be null");
        this.right = Objects.requireNonNull(right, "Right operand must not be null");
    }

    @Override
    public String toString() {
        return "(" + left.toString() + " + " + right.toString() + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Addition)) return false;
        Addition that = (Addition) obj;
        return this.left.equals(that.left) && this.right.equals(that.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}