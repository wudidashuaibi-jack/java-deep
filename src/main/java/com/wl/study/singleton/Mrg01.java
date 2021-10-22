package com.wl.study.singleton;

public class Mrg01 {
    private final static Mrg01  mrg01 = new Mrg01();

    private Mrg01(){}

    public Mrg01 getInstance(){
        return mrg01;
    }
}
