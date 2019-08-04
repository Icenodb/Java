package com.icenodb.tickts;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
public class Ticket {
    //线程间共享图书数量（恍惚了，想成卖票了，名字就取错了）
    public static int num=1;
    public static int minusNum(){
        num--;
        return num;
    }
    public static int addNum(){
        num++;
        return num;
    }
}
