package io.exer;

import java.io.*;
import java.util.Scanner;

public class EncryptionTest {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {
        System.out.print("请输入密码：");
        String passwd = scanner.nextLine();
        Encryption.encryptionAndDecryption("iotest/唐可可.jpg", "iotest/唐可可-encryption.jpg", passwd);

        System.out.print("请输入密码：");
        passwd = scanner.nextLine();
        Encryption.encryptionAndDecryption("iotest/唐可可-encryption.jpg", "iotest/唐可可-decryption.jpg", passwd);
    }
}

class Encryption {
    public static void encryptionAndDecryption(String origin, String dest, String passwd) {
        int hash = passwd.hashCode();

        BufferedOutputStream bos = null;
        BufferedInputStream bis = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(origin));
            bos = new BufferedOutputStream(new FileOutputStream(dest));

            byte[] bBuf = new byte[1024];
            int len;
            while ((len = bis.read(bBuf)) != -1) {
                for (int i = 0; i < len; i++) {
                    bBuf[i] ^= hash;
                }

                bos.write(bBuf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bos != null) {
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (bis != null) {
                        bis.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
