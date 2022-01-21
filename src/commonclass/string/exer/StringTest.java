package commonclass.string.exer;

import java.util.Arrays;

public class StringTest {
    String str = new String("good");
    char[] ch = {'t', 'e', 's', 't'};

    public void change(String str, char[] ch) {
        str = "test ok";
        ch[0] = 'b';
    }

    public static void main(String[] args) {
        StringTest st = new StringTest();

        st.change(st.str, st.ch);

        System.out.println("st.str = " + st.str); // good
        System.out.println("st.ch = " + Arrays.toString(st.ch)); // [b, e, s, t]
    }
}
