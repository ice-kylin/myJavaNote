package io.exer;

import org.junit.Test;

import java.io.File;
import java.util.Objects;

public class LsAsTreeTest {
    @Test
    public void test1() {
        File file = new File("./lstree");
        LsAsTree.show(file);
    }
}

class LsAsTree {
    public static void show(File file) {
        showIndent(file, 0);
    }

    private static void showIndent(File file, int indentLevel) {
        StringBuilder indentSpace = new StringBuilder();

        indentSpace.append("  ".repeat(Math.max(0, indentLevel)));

        if (file.isDirectory()) {
            indentSpace.append("└─ ").append(file.getName());
            System.out.println(indentSpace);

            for (File listFile : Objects.requireNonNull(file.listFiles())) {
                showIndent(listFile, indentLevel + 1);
            }
        } else {
            System.out.println(indentSpace.append("├─ ").append(file.getName()));
        }
    }
}
