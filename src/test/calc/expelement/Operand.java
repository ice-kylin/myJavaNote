package test.calc.expelement;

import test.calc.exp.Computable;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Operand implements Computable, ExpElement {
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

    @Override
    public double getValue() {
        return (isPositive ? 1 : -1) * Double.parseDouble(operand);
    }

    @Override
    public String toString() {
        return (isPositive ? "" : "-") + getValue();
    }
}
