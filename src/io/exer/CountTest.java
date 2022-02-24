package io.exer;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

/*
# 字数统计
 */
public class CountTest {
    public static void main(String[] args) {
        BufferedWriter bw = null;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("iotest/秋树.txt"));
            bw = new BufferedWriter(new FileWriter("iotest/秋树-count.txt"));

            LinkedHashMap<Character, Integer> charCount = new LinkedHashMap<>();
            int i;
            char c;
            int count;
            while ((i = br.read()) != -1) {
                c = (char) i;
                count = charCount.getOrDefault(c, 0);

                charCount.put(c, ++count);
            }

            for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
                bw.write(entry.getKey() + "：" + entry.getValue() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (br != null) {
                        br.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
