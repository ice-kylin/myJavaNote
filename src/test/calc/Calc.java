package test.calc;

import test.calc.exp.InfixExp;
import test.calc.exp.ReversePolishExp;
import test.calc.expelement.ExpElement;
import test.calc.expelement.Operand;
import test.calc.expelement.Operator;

import java.util.Stack;

public class Calc {
    public static InfixExp parseExp(String exp) throws Exception {
        exp = exp.replace(" ", "").replace(",", "");
        InfixExp infixExp = new InfixExp();

        StringBuilder numSB = new StringBuilder();
        boolean isPositive = true;

        for (int i = 0; i < exp.length(); ) {
            if (Operand.OPERANDS.contains(exp.charAt(i))) { // 如果是数字，将其加入 numSB
                numSB.append(exp.charAt(i));

                if (i == exp.length() - 1) { // 如果是最后一个字符，将 numSB 加入 infixExp
                    infixExp.addInfixExpElement(new Operand(isPositive, numSB.toString()));
                }

                i++;
            } else { // 如果是其它符号
                // 获取最长公共子串长度
                int operatorLength = getOperatorLength(exp, i);
                if (numSB.length() == 0) { // 如果 numSB 为空
                    if (exp.charAt(i) == '-') { // 如果是负号，改变正负
                        isPositive = !isPositive;

                        i++;
                    } else if (exp.charAt(i) == '+') { // 如果是加号，不进行操作
                        i++;
                    } else { // 如果是运算符，将其加入 infixExp
                        infixExp.addInfixExpElement(new Operator(exp.substring(i, i + operatorLength)));

                        i += operatorLength;
                    }
                } else { // 如果 numSB 不为空，将 numSB 加入 infixExp、并将运算符加入 infixExp
                    infixExp.addInfixExpElement(new Operand(isPositive, numSB.toString()));
                    infixExp.addInfixExpElement(new Operator(exp.substring(i, i + operatorLength)));

                    isPositive = true;
                    numSB.delete(0, numSB.length());

                    i += operatorLength;
                }
            }
        }

        return infixExp;
    }

    public static ReversePolishExp convertToReversePolishExp(InfixExp exp) {
        ReversePolishExp reversePolishExp = new ReversePolishExp();
        Stack<Operator> operatorStack = new Stack<>();

        for (ExpElement infixExpElement : exp.getInfixExpElements()) {
            if (infixExpElement instanceof Operand) {
                reversePolishExp.addReversePolishExpElement(infixExpElement);
            } else {
                if (infixExpElement instanceof Operator) {
                    Operator infixExpOperator = (Operator) infixExpElement;
                    String infixExpOperatorStr = infixExpOperator.getOperator();
                    if ("(".equals(infixExpOperatorStr)) {
                        operatorStack.push(infixExpOperator);
                    } else if (")".equals(infixExpOperatorStr)) {
                        while (!"(".equals(operatorStack.peek().getOperator())) {
                            reversePolishExp.addReversePolishExpElement(operatorStack.pop());
                        }

                        operatorStack.pop();
                    } else {
                        while (
                                !operatorStack.isEmpty() &&
                                        (Operator.OPERATORS.get(operatorStack.peek().getOperator()) <=
                                                Operator.OPERATORS.get(infixExpOperatorStr)) &&
                                        !"(".equals(operatorStack.peek().getOperator())
                        ) {
                            reversePolishExp.addReversePolishExpElement(operatorStack.pop());
                        }

                        operatorStack.push(infixExpOperator);
                    }
                }
            }
        }

        int size = operatorStack.size();
        for (int i = 0; i < size; i++) {
            Operator operator = operatorStack.pop();
            if (!"(".equals(operator.getOperator())) {
                reversePolishExp.addReversePolishExpElement(operator);
            }
        }

        return reversePolishExp;
    }

    private static int getOperatorLength(String exp, int i) throws Exception {
        int len = 0;

        for (String operator : Operator.OPERATORS.keySet()) {
            if (exp.startsWith(operator, i)) {
                if (operator.length() > len) {
                    len = operator.length();
                }
            }
        }

        if (len > 0) {
            return len;
        } else {
            throw new Exception("no such operator");
        }
    }
}
