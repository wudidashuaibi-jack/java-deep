package com.wl.study.singleton;

public class Mrg04 {

    private static Mrg04 Instance;

    /**
     * DCL(Double check lock) 双重校验锁
     * 仍然存在问题 有可能new对象时发生指令重排序，导致等待的线程拿到了半初始化的对象
     * 解决 加volatile,作用：保障可见性，禁止指令重排序
     */
    public static synchronized Mrg04 getInstance(){
        if(Instance==null){//这行代码可以去除，但会影响效率
            synchronized (Mrg04.class){
                if(Instance==null){
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Instance = new Mrg04();
                }
            }
        }
        return Instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(Mrg04.getInstance().hashCode());
            }).start();
        }
    }
}
