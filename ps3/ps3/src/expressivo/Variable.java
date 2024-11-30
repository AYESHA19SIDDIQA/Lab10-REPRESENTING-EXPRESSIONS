package expressivo;

import java.util.Objects;

/**
 * Represents a variable in an expression.
 * Immutable class.
 */
public class Variable implements Expression {
    private final String name; // the name of the variable

    /**
     * Creates a variable expression with the given name.
     * @param name the name of the variable
     */
    public Variable(String name) {
        if (name == null || name.isEmpty() || !name.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("Variable name must be a non-empty string of letters.");
        }
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Variable)) return false;
        Variable that = (Variable) obj;
        return this.name.equals(that.name); // Compare variable names
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
