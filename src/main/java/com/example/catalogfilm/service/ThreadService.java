package com.example.catalogfilm.service;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

public class ThreadService {

    @HystrixCommand(fallbackMethod = "defaultStart",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
            }
    )
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

    public static void defaultStart(){
        Thread th1 = new CustomThread();

        th1.setName("thread_1");

        th1.start();

    }
}
