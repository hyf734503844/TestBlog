package com;

public class Baozipu implements Runnable{
    private Baozi baozi;

    Baozipu(Baozi baozi){
        this.baozi=baozi;
    }


    @Override
    public void run() {
        while(true) {
            synchronized (baozi) {

                if(!baozi.flag) {
                    try {
                        baozi.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                    System.out.println("包子铺做包子");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    baozi.flag = false;
                    baozi.notify();
            }
        }
    }
}
