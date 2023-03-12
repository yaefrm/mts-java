package com.example.catalogfilm.service;


public class CounterService {
    private static int counter = 0;

    public static int getCounter(){ return counter;}

    public synchronized static void increment() {
        counter += 1;
    }
}

class CustomThread extends Thread{
    @Override
    public void run() {
        System.out.println(this.getName());
        for (int i=0; i < 1000000; ++i){
            CounterService.increment();
            System.out.println(this.getName() + " " + CounterService.getCounter());
        }
    }
}