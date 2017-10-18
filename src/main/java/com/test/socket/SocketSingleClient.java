package com.test.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by szh on 2017/9/10.
 */
public class SocketSingleClient extends Thread {

    InputStream inputStream = null;

    SocketSingleClient(InputStream stream) {
        this.inputStream = stream;
        this.start();
    }

    @Override
    public void run() {
        try {
            RandomAccessFile accessFile = new RandomAccessFile("out/socketServerMessage.txt","rw");
            accessFile.seek(accessFile.length());
            BufferedReader reader = new BufferedReader(new InputStreamReader(this.inputStream));
            String tmpLine = null;
            while((tmpLine = reader.readLine()) != null){
                accessFile.write((tmpLine+"\r\n").getBytes());
                System.out.println(tmpLine);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {

        Socket clientSocket = new Socket(InetAddress.getByAddress(new byte[]{127, 0, 0, 1}), 8080);

        InputStream inputStream = clientSocket.getInputStream();
        OutputStream outputStream = clientSocket.getOutputStream();
        PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));

        //创建一个线程用于输出服务端的输入
        new SocketSingleClient(inputStream);

        Scanner scanner = new Scanner(System.in);
        String tmpLine = null;
        while (!(tmpLine = scanner.nextLine()).equals("exit")) {
            writer.println("Client Say : " + tmpLine);
            writer.flush();
        }
    }
}
