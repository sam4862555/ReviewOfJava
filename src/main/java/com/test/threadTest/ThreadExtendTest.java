package com.test.threadTest;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * Created by szh on 2017/8/30.
 */
public class ThreadExtendTest extends Thread {

    public static File outfile = null;
    public static FileOutputStream outStream = null;
    public static BufferedOutputStream bufferedOutputStream = null;
    public static PrintStream ps = null;

    static {
        try {
            outfile = new File("out/ThreadTestOutput");
            if (!outfile.exists()) {
                outfile.createNewFile();
            } else {
                File oldFile = new File("out/ThreadTestOutputOld");
                if (oldFile.exists()) {
                    oldFile.delete();
                }
                System.out.println(outfile.renameTo(oldFile));
            }
            outStream = new FileOutputStream(outfile);
            bufferedOutputStream = new BufferedOutputStream(outStream, 1024);
            ps = new PrintStream(bufferedOutputStream, true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static PrintStream getStream() {
        return ps;
    }

    ThreadExtendTest(String name) {
        super(name);
    }


    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            synchronized (this.getClass()) {
                System.out.println(Thread.currentThread().getName() + "\nValue of i:" + i + "\nPriority :" + this.getPriority());
            }
            if (i == 20) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Thread setThread = new Thread(new ThreadExtendTest("setCreateThread"));
        Thread newThread = new ThreadExtendTest("newCreateThread");

        PrintStream orgin = System.out;
        System.setOut(getStream());
        setThread.start();
        newThread.start();
        setThread.join();
        newThread.join();

        ps.flush();
        ps.close();

        System.setOut(orgin);
        if (!setThread.isAlive()) {
            System.out.println("线程已经处于死亡期");
        }

    }
}
