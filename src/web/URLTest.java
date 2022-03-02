package web;

import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/*
# URL

- URL：统一资源定位符，对应着互联网的某一资源地址
- 格式
  - 通信协议://主机名:端口号/资源地址?参数列表#片段名
  - `https://translate.google.com/?sl=zh-CN&tl=en&op=translate`
 */
public class URLTest {
    @Test
    public void test1() {
        try {
            URL url = new URL("https://translate.google.com/?sl=zh-CN&tl=en&op=translate");

            System.out.println("url.getProtocol() = " + url.getProtocol()); // 获取该 URL 的协议名
            System.out.println("url.getHost() = " + url.getHost()); // 获取该 URL 的主机名
            System.out.println("url.getPort() = " + url.getPort()); // 获取该 URL 的端口号
            System.out.println("url.getPath() = " + url.getPath()); // 获取该 URL 的文件路径
            System.out.println("url.getFile() = " + url.getFile()); // 获取该 URL 的文件名
            System.out.println("url.getQuery() = " + url.getQuery()); // 获取该 URL 的查询名
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() {
        BufferedOutputStream bos = null;
        BufferedInputStream bis = null;
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL("https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png");
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.connect();
            bis = new BufferedInputStream(urlConnection.getInputStream());

            String[] split = url.getPath().split("/");
            bos = new BufferedOutputStream(
                    new FileOutputStream("webtest/" + split[split.length - 1])
            );

            byte[] bBuf = new byte[1024];
            int len;
            while ((len = bis.read(bBuf)) != -1) {
                bos.write(bBuf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
    }
}
