package com.example.leetcodedemo.skill;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Test_01 {
    public static void main(String[] args) {
        int i = 56;
        System.out.println(i%10);
        System.out.println(i/10);

        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
        readLock.lock();

        ConcurrentHashMap map = new ConcurrentHashMap();
        map.put("","");
        System.out.println();


    }
}
