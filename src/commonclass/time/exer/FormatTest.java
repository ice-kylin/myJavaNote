package commonclass.time.exer;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class FormatTest {
    public static void main(String[] args) {
        String s1 = "2022-09-08";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;

        try {
            date = new Date(sdf.parse(s1).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println("date = " + date);
    }
}
