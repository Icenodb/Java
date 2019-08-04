package com.icenodb.tickts;
import java.util.concurrent.CountDownLatch;

//借出去书
public class LibraryOut implements Runnable {
    public static CountDownLatch countDownLatch = new CountDownLatch(1); //用这个可以让图书馆借完书之后等待归还而不是终止线程

    @Override
    public void run() {
        tick();
    }

    public void tick() {
        synchronized (Ticket.class) {
            for (int i = 0; i < Math.random() + 5; i++) {
                if (Ticket.num >= 1) {
                    Ticket.minusNum();
                    System.out.println("借书出去，还剩" + Ticket.num + "本");
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("书不够啦，请等带其他同学来还书");
                    try {
                        countDownLatch.await();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
