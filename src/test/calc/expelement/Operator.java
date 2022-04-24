package test.calc.expelement;

import java.util.LinkedHashMap;
import java.util.Objects;

public class Operator implements ExpElement {
    public static final LinkedHashMap<String, Integer> OPERATORS = new LinkedHashMap<>();

    static {
        OPERATORS.put("(", 0);
        OPERATORS.put(")", 0);
        OPERATORS.put("π", 1);
        OPERATORS.put("e", 1);
        OPERATORS.put("%", 2); // 百分号
        OPERATORS.put("!", 2);
        OPERATORS.put("^", 3);
        OPERATORS.put("√", 3);
        OPERATORS.put("∛", 3);
        OPERATORS.put("ln", 3);
        OPERATORS.put("log", 3);
        OPERATORS.put("sin", 3);
        OPERATORS.put("cos", 3);
        OPERATORS.put("tan", 3);
        OPERATORS.put("sin⁻¹", 3);
        OPERATORS.put("cos⁻¹", 3);
        OPERATORS.put("tan⁻¹", 3);
        OPERATORS.put("×", 4);
        OPERATORS.put("÷", 4);
        OPERATORS.put("+", 5);
        OPERATORS.put("—", 5);
    }

    private final String operator;

    public Operator(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Operator operator1 = (Operator) o;

        return Objects.equals(operator, operator1.operator);
    }

    @Override
    public int hashCode() {
        return operator != null ? operator.hashCode() : 0;
    }

    @Override
    public String toString() {
        return operator;
    }
}
