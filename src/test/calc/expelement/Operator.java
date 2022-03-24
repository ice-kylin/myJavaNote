package test.calc.expelement;

import java.util.LinkedHashMap;
import java.util.Objects;

public class Operator implements ExpElement {
    public static final LinkedHashMap<String, Integer> operators = new LinkedHashMap<>();

    static {
        operators.put("(", 0);
        operators.put(")", 0);
        operators.put("π", 1);
        operators.put("e", 1);
        operators.put("%", 2); // 百分号
        operators.put("!", 2);
        operators.put("^", 3);
        operators.put("√", 3);
        operators.put("∛", 3);
        operators.put("ln", 3);
        operators.put("log", 3);
        operators.put("sin", 3);
        operators.put("cos", 3);
        operators.put("tan", 3);
        operators.put("sin⁻¹", 3);
        operators.put("cos⁻¹", 3);
        operators.put("tan⁻¹", 3);
        operators.put("×", 4);
        operators.put("÷", 4);
        operators.put("+", 5);
        operators.put("—", 5);
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
