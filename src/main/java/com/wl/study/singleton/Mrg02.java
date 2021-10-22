package com.wl.study.singleton;

/**
 * 懒汉式单例
 */
public class Mrg02 {

    private static Mrg02 Instance;

    /***
     *  问题：多线程数据一致性的问题
     */
    public static Mrg02 getInstance(){
        if(Instance==null){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Instance = new Mrg02();
        }
        return Instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(Mrg02.getInstance().hashCode());
            }).start();
        }
    }

}
