package com.test.socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * Created by szh on 2017/9/12.
 */
public class UDPSocketClient {

    public static InetAddress serverAddr = null;
    public static int serverPort = -1;

    static {
        try {
            serverAddr = InetAddress.getByAddress(new byte[]{127, 0, 0, 1});
            serverPort = 41002;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        DatagramSocket datagramSocket = null;
        try {
            datagramSocket = new DatagramSocket(42000+ (int)Math.floor(Math.random()*1000));
            Scanner scanner = new Scanner(System.in);
            String line = null;

            while (!(line = scanner.nextLine()).equals("exit")) {
                byte[] byteMsg = line.getBytes();
                if (serverPort != -1 && serverAddr != null){
                    DatagramPacket sendPacket = new DatagramPacket(new byte[0], 0, serverAddr, serverPort);
                    sendPacket.setData(byteMsg);
                    System.out.println("发送消息");
                    datagramSocket.send(sendPacket);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            datagramSocket.close();
        }
    }
}
