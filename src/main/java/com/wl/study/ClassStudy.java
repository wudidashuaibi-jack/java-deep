package com.wl.study;

import org.openjdk.jol.info.ClassLayout;

import java.lang.reflect.Array;

/**
 * 对象在内存中的存储分布
 * markword(8 bit)(存放锁的信息、gc标记信息、hashcode信息)、classpointer(4 bit)、instance data、padding(补齐)
 * 添加依赖
 <dependency>
 <groupId>org.openjdk.jol</groupId>
 <artifactId>jol-core</artifactId>
 <version>0.9</version>
 </dependency>
 数组在内存中略有不同多了一个数组长度4个字节
 */
public class ClassStudy {

    private static class T{
//        String str = "1545"; 引用类型存在的情况下 boolean short char 会内部补齐到四个字节的倍数
        boolean flag;
//        char c;
        short aShort;
        int a;
//        int[] array = {};
    }

    public static void main(String[] args) {
        T t = new T();
        int[] a = new int[5];
        System.out.println(ClassLayout.parseInstance(t).toPrintable());
    }
}
