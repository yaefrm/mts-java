package com.example.catalogfilm.service;


public class ThreadService {
    public static void start(){
        Thread th1 = new CustomThread();
        Thread th2 = new CustomThread();
        Thread th3 = new CustomThread();

        th1.setName("thread_1");
        th2.setName("thread_2");
        th3.setName("thread_3");

        th1.start();
        th2.start();
        th3.start();


    }
}
