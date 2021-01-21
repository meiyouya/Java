package com.lawliet.thread;

import javax.swing.*;
import java.awt.*;

public class JoinTest extends JFrame {

    private Thread threadA;
    private Thread threadB;

    final JProgressBar bar1 = new JProgressBar();
    final JProgressBar bar2 = new JProgressBar();

    private JoinTest() {
        super();
        getContentPane().add(bar1, BorderLayout.NORTH);
        getContentPane().add(bar2, BorderLayout.SOUTH);
        bar1.setStringPainted(true);
        bar2.setStringPainted(true);

        threadA = new Thread(new Runnable() {
            int count = 0;
            @Override
            public void run() {
                while (true) {
                    bar1.setValue(++count);
                    try {
                        Thread.sleep(100);
                        // 在特定条件下，启动另一个线程，也可以在其他地方事先启动，让其先运行着
                        if (count == 30) {
                            threadB.start();
                            // 调用join方法后，当前线程会等待调用join方法的线程执行完毕后再继续执行
                            threadB.join();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        threadA.start();
        threadB = new Thread(new Runnable() {
            int count = 0;
            @Override
            public void run() {
                while (true) {
                    bar2.setValue(++count);
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (count == 100) {
                        break;
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        init(new JoinTest(), 300, 200);
    }

    private static void init(JFrame frame, int width, int height) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setVisible(true);
    }
}
