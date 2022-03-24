package test.calc.expelement;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Operand implements ExpElement {
    public static final Set<Character> OPERAND_CHARS = new HashSet<>(
            Arrays.asList(
                    '0',
                    '1',
                    '2',
                    '3',
                    '4',
                    '5',
                    '6',
                    '7',
                    '8',
                    '9',
                    '.'
            )
    );

    private final boolean isPositive;
    private final String operand;

    public Operand(boolean isPositive, String operand) {
        this.isPositive = isPositive;
        this.operand = operand;
    }

    public double getValue() {
        return (isPositive ? 1 : -1) * Double.parseDouble(operand);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Operand operand1 = (Operand) o;

        if (isPositive != operand1.isPositive) return false;
        return Objects.equals(operand, operand1.operand);
    }

    @Override
    public int hashCode() {
        int result = (isPositive ? 1 : 0);
        result = 31 * result + (operand != null ? operand.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return (isPositive ? "" : "-") + getValue();
    }
}
