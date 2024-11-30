package expressivo;

import java.util.Objects;

/**
 * Represents a numeric literal in an expression.
 * Immutable class.
 */
public class Literal implements Expression {
    private final double value; // the numeric value of this literal

    /**
     * Creates a literal expression with the given value.
     * @param value the numeric value
     */
    public Literal(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Literal)) return false;
        Literal that = (Literal) obj;
        return Double.compare(this.value, that.value) == 0; // Compare numeric values
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
