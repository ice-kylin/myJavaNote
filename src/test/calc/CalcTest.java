package test.calc;

import org.junit.Test;

public class CalcTest {
    @Test
    public void testParseExp() throws Exception {
        System.out.println(Calc.parseExp("1 + 1 × 6 + (2 × 2.33 + 66.6) × 88") + "\n");
        System.out.println(Calc.parseExp("1 + 1 × 6 + (2 × 2.33)") + "\n");
        System.out.println(Calc.parseExp("3^2 + 3") + "\n");
        System.out.println(Calc.parseExp("sin(90") + "\n");
        System.out.println(Calc.parseExp("sin(3!") + "\n");
        System.out.println(Calc.parseExp("log(10) + 2") + "\n");
        System.out.println(Calc.parseExp("sin⁻¹(2 ÷ 3 + 9"));
    }

    @Test
    public void testConvertToReversePolishExp() throws Exception {
        System.out.println(Calc.convertToReversePolishExp(Calc.parseExp("1 + 1 × 6 + (2 × 2.33 + 66.6) × 88")) + "\n");
        System.out.println(Calc.convertToReversePolishExp(Calc.parseExp("1 + 1 × 6 + (2 × 2.33)")) + "\n");
        System.out.println(Calc.convertToReversePolishExp(Calc.parseExp("3^2 + 3")) + "\n");
        System.out.println(Calc.convertToReversePolishExp(Calc.parseExp("sin(90")) + "\n");
        System.out.println(Calc.convertToReversePolishExp(Calc.parseExp("sin(3!")) + "\n");
        System.out.println(Calc.convertToReversePolishExp(Calc.parseExp("log(10) + 2")) + "\n");
        System.out.println(Calc.convertToReversePolishExp(Calc.parseExp("sin⁻¹(2 ÷ 3 + 9")));
    }
}
