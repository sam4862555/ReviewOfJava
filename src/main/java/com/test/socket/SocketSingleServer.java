package com.test.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by szh on 2017/9/10.
 */
public class SocketSingleServer extends Thread {

    public static Boolean exitSignal = false;

    InputStream inputStream = null;

    SocketSingleServer(InputStream stream) {
        this.inputStream = stream;
        this.start();
    }

    @Override
    public void run() {
        try {
            RandomAccessFile accessFile = new RandomAccessFile("out/socketClientMessage.txt", "rw");
            accessFile.seek(accessFile.length());
            BufferedReader reader = new BufferedReader(new InputStreamReader(this.inputStream));
            String tmpLine = null;
            while(true){
                synchronized (SocketSingleServer.exitSignal){
                    if(SocketSingleServer.exitSignal) break;
                    while(reader.ready()){
                        tmpLine = reader.readLine();
                        accessFile.write((tmpLine+"\r\n").getBytes());
                        System.out.println(tmpLine);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        ServerSocket serverSocket = null;
        Socket s = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        PrintWriter writer = null;

        SocketSingleServer serverThread = null;

        try {
            serverSocket = new ServerSocket(8080);
            //会阻塞进程
            s = serverSocket.accept();
            if (s != null) {
                System.out.println("建立连接");

                inputStream = s.getInputStream();
                outputStream = s.getOutputStream();
                writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));

                serverThread = new SocketSingleServer(inputStream);

                Scanner scanner = new Scanner(System.in);
                String tmpLine = null;
                while (!(tmpLine = scanner.nextLine()).equals("exit")) {
                    writer.println("Server Say : " + tmpLine);
                    writer.flush();
                }
//                synchronized (SocketSingleServer.exitSignal){
//                    SocketSingleServer.exitSignal = true;
//                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                synchronized (SocketSingleServer.exitSignal){
                    SocketSingleServer.exitSignal = true;
                    s.shutdownInput();
                    writer.close();
                    outputStream.close();
                    inputStream.close();
                    s.close();
                 }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

