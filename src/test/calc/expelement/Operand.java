package test.calc.expelement;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Operand implements ExpElement {
    public static final Set<Character> OPERANDS = new HashSet<>(
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
    private final double operand;

    public Operand(boolean isPositive, String operand) {
        this.isPositive = isPositive;
        this.operand = Double.parseDouble(operand);
    }

    public double getValue() {
        return (isPositive ? 1 : -1) * operand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Operand operand1 = (Operand) o;

        if (isPositive != operand1.isPositive) return false;
        return Double.compare(operand1.operand, operand) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (isPositive ? 1 : 0);
        temp = Double.doubleToLongBits(operand);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return (isPositive ? "" : "-") + getValue();
    }
}
