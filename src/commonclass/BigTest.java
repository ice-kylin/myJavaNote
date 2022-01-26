package commonclass;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class BigTest {
    @Test
    public void test1() {
        BigInteger bi = new BigInteger("37198371289371289");
        BigDecimal bd1 = new BigDecimal("12435.351");
        BigDecimal bd2 = new BigDecimal("11");

        System.out.println(bi);

        System.out.println(bd1.divide(bd2, RoundingMode.HALF_UP));
        System.out.println(bd1.divide(bd2, 15, RoundingMode.HALF_UP));
    }
}
