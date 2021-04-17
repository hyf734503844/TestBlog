package com;

public class Chihuo implements Runnable{
    public Baozi baozi;

    Chihuo(Baozi baozi){
        this.baozi=baozi;
    }
    @Override
    public void run() {
        while(true) {
            synchronized (baozi) {

                if(baozi.flag) {
                    try {
                        baozi.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                    System.out.println("吃货吃包子--------------");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    baozi.flag = true;
                    baozi.notify();
            }
        }
    }
}
