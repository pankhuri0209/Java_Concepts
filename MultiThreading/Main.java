package com.MultiThreading;

import java.sql.SQLOutput;

import static com.MultiThreading.ThreadColor.*;

public class Main {

    public static void main(String[] args){

        System.out.println(ANSI_GREEN+"Hello from main method");   //1
        Thread obj= new myThread();
        obj.setName("Another == thread==");
        //obj.start();                                    //2
        obj.run();
        new Thread(){
            public void run()
            {
                System.out.println(ANSI_RED+"Hello from anonymous class");   //3
            }
        }.start();

        Thread myRunnableThread= new Thread(new myRunnable(){
            @Override
            public void run(){
                //super.run();
                System.out.println(ANSI_BLUE+   "Hello from anonymous runnable interface");

                try{
                    obj.join(2000);
                    System.out.println(ANSI_RED+"Another cthread terminated, so I am running ");
                }
                catch (InterruptedException e)
                {
                    System.out.println(ANSI_RED+"I could'nt wait after all. I was interrupted");
                }

            }
        });
        myRunnableThread.start();
    //    obj.interrupt();

        System.out.println(ANSI_BLACK+"Hello again from main method"); //4

    }

    class Countown{

        public void doCountdown(){

            String color;

            switch (Thread.currentThread().getName())
            {
                case "Thread 1":
                    color= ThreadColor.ANSI_BLUE;
                    break;

                case "Thread 2":
                    color= ThreadColor.ANSI_RED;
                    break;
                default:
                    color= ThreadColor.ANSI_GREEN;

            }
            for (int i=10;i>0;i--)
            {
                System.out.println(color+ Thread.currentThread().getName()+":i="+i);
            }
        }

    }
    class CountdownThread extends Thread{

        private Countown threadCountdown;

        public CountdownThread(Countown countdown)
        {
            threadCountdown= countdown;
        }
        public void run(){
            threadCountdown.doCountdown();
        }
    }

}
