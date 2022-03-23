package test.calc.exp;

import test.calc.expelement.ExpElement;

import java.util.LinkedList;

public class InfixExp {
    private final LinkedList<ExpElement> infixExpElements = new LinkedList<>();

    public LinkedList<ExpElement> getInfixExpElements() {
        return infixExpElements;
    }

    public void addInfixExpElement(ExpElement expElement) {
        infixExpElements.add(expElement);
    }

    @Override
    public String toString() {
        StringBuilder infixExpSB = new StringBuilder();

        for (ExpElement infixExpElement : infixExpElements) {
            infixExpSB.append(infixExpElement).append("\n");
        }

        return infixExpSB.toString();
    }
}
