package com.icenodb.tickts;
//归还书本
public class LibraryIn implements Runnable {
    @Override
    public void run(){
        tick();
    }
    public void tick(){
        synchronized (Ticket.class) {
            try{
            for (int i = 0; i < Math.random() + 5; i++) {
                if (Ticket.num < 3) {
                    Ticket.addNum();
                    System.out.println("还书回来，还剩" + Ticket.num + "本");
                    Thread.sleep(1000);
                }else {
                    System.out.println("库存已满，无需还书");
                    LibraryOut.countDownLatch.countDown();
                    break;
                }
            }
        }catch (Exception e){e.printStackTrace();}
        }
    }
}
