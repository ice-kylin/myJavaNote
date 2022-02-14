package collectionmap.exer;

import java.util.HashMap;
import java.util.Map;

public class LastNameStatisticsTest {
    public static void main(String[] args) {
        String names = "张 三\n李 四\n王 五\n张 四\n 欧阳 兴平";
        HashMap lastNameOccurrencesMap = new HashMap();

        for (String name : names.split("\n")) {
            name = name.trim();
            String lastName = name.split(" ", 2)[0];

            Object lastnameOccurrences = lastNameOccurrencesMap.get(lastName);
            Integer lastNameNum = lastnameOccurrences == null ? 0 : (Integer) lastnameOccurrences;

            lastNameOccurrencesMap.put(lastName, ++lastNameNum);
        }

        for (Object o : lastNameOccurrencesMap.entrySet()) {
            Map.Entry entry = (Map.Entry) o;

            System.out.println(entry.getKey() + "：" + entry.getValue());
        }
    }
}
