package array.exer;

public class LinearSearch {
    public static void main(String[] args) {
        String dest = "Issac";
        String[] names = new String[]{"Accker", "Issac", "Dyp"};
        boolean found = false;

        for (int i = 0; i < names.length; i++) {
            if (names[i].equals(dest)) {
                System.out.println("找到了，位置为：" + i);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("没找到");
        }
    }
}
