package com.test.socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.Scanner;

/**
 * Created by szh on 2017/9/12.
 */
public class UDPSocketServer extends Thread {

    public static DatagramSocket datagramSocket = null;
    public static InetAddress senderAddr = null;
    public static int senderPort = -1;

    static {
        try {
            datagramSocket = new DatagramSocket(new InetSocketAddress(InetAddress.getByAddress(new byte[]{127, 0, 0, 1}), 8080));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                byte[] buffer = new byte[8192];
                DatagramPacket packet = new DatagramPacket(buffer, 8192);
                datagramSocket.receive(packet);
                String msg = new String(packet.getData());
                senderAddr = packet.getAddress();
                senderPort = packet.getPort();
                System.out.println("Sender :\n  addr -> " + senderAddr + "\n  port -> " + senderPort + "\nMsg : " + msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            datagramSocket.close();
        }
    }

    public static void main(String[] args) {

        try {
            //将Server 绑定在本地的127.0.0.1 8080端口
            DatagramSocket datagramSocket = new DatagramSocket(new InetSocketAddress(InetAddress.getByAddress(new byte[]{127, 0, 0, 1}), 41002));

//            //创建一个读取客户端发送消息的进程 并启动
//            new UDPSocketServer().start();
//
//            Scanner scanner = new Scanner(System.in);
//            String line = null;
//            while (!(line = scanner.nextLine()).equals("exit")) {
//                if (senderPort != -1 && senderAddr != null) {
//                    byte[] byteMsg = line.getBytes();
//                    datagramSocket.send(new DatagramPacket(byteMsg, 0, byteMsg.length, senderAddr, senderPort));
//                }
//            }

            while (true) {
                byte[] buffer = new byte[8192];
                DatagramPacket packet = new DatagramPacket(buffer, 8192);
                datagramSocket.receive(packet);
                String msg = new String(packet.getData());
                senderAddr = packet.getAddress();
                senderPort = packet.getPort();
                System.out.println("Sender :\n  addr -> " + senderAddr + "\n  -> port " + senderPort + "\nMsg : " + msg);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            datagramSocket.close();
        }
    }
}
