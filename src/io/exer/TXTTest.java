package io.exer;

import org.junit.Test;

import java.io.File;
import java.util.Objects;

public class TXTTest {
    @Test
    public void test1() {
        File dir = new File(".");
        boolean isContainTXT = false;

        for (String fileName : Objects.requireNonNull(dir.list())) {
            if (fileName.endsWith(".txt") || fileName.endsWith(".TXT")) {
                System.out.println(fileName);
                isContainTXT = true;
            }
        }

        if (!isContainTXT) {
            System.out.println("不存在 .txt 文件");
        }
    }
}
