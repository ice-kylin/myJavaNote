package web;

import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPTest {
    // 发送端
    @Test
    public void testSender() {
        DatagramSocket ds = null;
        try {
            ds = new DatagramSocket();

            byte[] data = "Hello! I'm Sender.".getBytes();
            ds.send(new DatagramPacket(
                    data,
                    0,
                    data.length,
                    InetAddress.getByName("localhost"),
                    2333
            ));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ds != null) {
                ds.close();
            }
        }
    }

    // 接收端
    @Test
    public void testReceiver() {
        DatagramSocket ds = null;
        try {
            ds = new DatagramSocket(2333);

            byte[] bBuf = new byte[64];
            DatagramPacket packet = new DatagramPacket(bBuf, 0, bBuf.length);
            ds.receive(packet);
            System.out.println(new String(packet.getData(), 0, packet.getLength()));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ds != null) {
                ds.close();
            }
        }
    }
}
