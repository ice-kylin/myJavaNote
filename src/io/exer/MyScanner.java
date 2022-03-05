package io.exer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyScanner {
    private static final BufferedReader sbr = new BufferedReader(new InputStreamReader(System.in));

    public static String getNextString() {
        try {
            return sbr.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static int getNextInt() {
        return Integer.parseInt(getNextString());
    }

    public static double getNextDouble() {
        return Double.parseDouble(getNextString());
    }

    public static boolean getNextBoolean() {
        return Boolean.parseBoolean(getNextString());
    }

    public static void close() {
        try {
            sbr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
