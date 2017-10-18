package com.test.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by szh on 2017/9/10.
 */
public class SocketSingleClient extends Thread {

    public static Boolean exitSignal = false;
    InputStream inputStream = null;

    SocketSingleClient(InputStream stream) {
        this.inputStream = stream;
        this.start();
    }

    @Override
    public void run() {
        RandomAccessFile accessFile = null;
        BufferedReader reader = null;
        try {
            accessFile = new RandomAccessFile("out/socketServerMessage.txt", "rw");
            accessFile.seek(accessFile.length());
            reader = new BufferedReader(new InputStreamReader(this.inputStream));
            String tmpLine = null;
            while (true) {
                synchronized (SocketSingleClient.exitSignal) {
                    if (SocketSingleClient.exitSignal) break;
                    while (reader.ready()) {
                        tmpLine = reader.readLine();
                        accessFile.write((tmpLine + "\r\n").getBytes());
                        System.out.println(tmpLine);
                    }
                }
            }
            System.out.println("step2");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
                accessFile.close();
                this.inputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {

//        //带超时连接的socket
//        //The connection will then block until established or an error occurs.
//        Socket s = new Socket();
//        s.connect(new InetSocketAddress(InetAddress.getByAddress(new byte[]{127, 0, 0, 1}), 8080),4000);

        Socket clientSocket = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        PrintWriter writer = null;
        try {
            clientSocket = new Socket(InetAddress.getByAddress(new byte[]{127, 0, 0, 1}), 8080);

            inputStream = clientSocket.getInputStream();
            outputStream = clientSocket.getOutputStream();
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));

            //创建一个线程用于输出服务端的输入
            new SocketSingleClient(inputStream);

            Scanner scanner = new Scanner(System.in);
            String tmpLine = null;
            while (!(tmpLine = scanner.nextLine()).equals("exit")) {
                writer.println("Client Say : " + tmpLine);
                writer.flush();
            }
            synchronized (SocketSingleClient.exitSignal) {
                SocketSingleClient.exitSignal = true;
            }
            System.out.println("step1");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.shutdownInput();
                writer.close();
                inputStream.close();
                outputStream.close();
                clientSocket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
