package collectionmap.exer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class InputNumTest {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();

        for (int i = 0; i < 10; i++) {
            System.out.print(i + 1 + ": ");
            arrayList.add(scanner.nextInt());
        }

        Collections.reverse(arrayList);
        System.out.println(arrayList);

        Collections.sort(arrayList, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Integer && o2 instanceof Integer) {
                    return ((Integer) o2).compareTo((Integer) o1);
                } else {
                    throw new IllegalArgumentException("传入的参数类型不一致");
                }
            }
        });
        System.out.println(arrayList);
    }
}
