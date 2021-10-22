package com.wl.study;

import java.util.concurrent.CountDownLatch;

/**
 * 描述指令重排，单线程的排序必須保持最終一致性
 */
public class Disorder {

    private static int a = 0, b = 0;

    private static int x= 0,y=0;

    public static void main(String[] args) throws InterruptedException {
        for (long i = 0; i <Long.MAX_VALUE ; i++) {
            x=0;
            y=0;
            a=0;
            b=0;
            CountDownLatch latch = new CountDownLatch(2);


            Thread one = new Thread(new Runnable() {
                @Override
                public void run() {
                    a=1;
                    x=b;
                    latch.countDown();
                }
            });

            Thread other = new Thread(new Runnable() {
                @Override
                public void run() {
                    b=1;
                    y=a;
                    latch.countDown();
                }
            });
            one.start();
            other.start();
            latch.await();
            String result = "第"+i+"次（"+x+","+y+")";
            if(x==0 && y==0){
                System.err.println(result);
                break;
            }
        }
    }

}

