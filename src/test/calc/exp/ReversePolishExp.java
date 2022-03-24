package test.calc.exp;

import test.calc.expelement.ExpElement;

import java.util.LinkedList;

public class ReversePolishExp {
    private final LinkedList<ExpElement> reversePolishExpElements = new LinkedList<>();

    public LinkedList<ExpElement> getReversePolishExpElements() {
        return reversePolishExpElements;
    }

    public void addReversePolishExpElement(ExpElement expElement) {
        reversePolishExpElements.add(expElement);
    }

    @Override
    public String toString() {
        StringBuilder reversePolishExpSB = new StringBuilder();

        for (ExpElement reversePolishExpElement : reversePolishExpElements) {
            reversePolishExpSB.append(reversePolishExpElement).append("\n");
        }

        return reversePolishExpSB.toString();
    }
}
