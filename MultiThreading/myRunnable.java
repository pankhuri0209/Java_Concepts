package com.MultiThreading;

import static com.MultiThreading.ThreadColor.ANSI_RED;

public class myRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println(ANSI_RED+"Inside runnable class");
    }
}
