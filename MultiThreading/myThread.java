package com.MultiThreading;

import static com.MultiThreading.ThreadColor.ANSI_BLUE;

public class myThread extends java.lang.Thread {

    @Override
    public void run(){
        System.out.println(ANSI_BLUE+"Hello from thread"+currentThread().getName());

    try{
        Thread.sleep(3000);
    }
    catch (InterruptedException e)
    {
        System.out.println(ANSI_BLUE+"Another thread woke me up");
    }
        System.out.println(ANSI_BLUE+"Three seconds have passed and I am awake");

    }
}
