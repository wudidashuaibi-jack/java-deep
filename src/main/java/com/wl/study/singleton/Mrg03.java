package com.wl.study.singleton;

public class Mrg03 {

    private static Mrg03 Instance;

    /**
     * 粗略的解决了问题
     */
    public static synchronized Mrg03 getInstance(){
        if(Instance==null){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Instance = new Mrg03();
        }
        return Instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(Mrg03.getInstance().hashCode());
            }).start();
        }
    }
}
