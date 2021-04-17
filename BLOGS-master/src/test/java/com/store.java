package com;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class store implements Runnable{
   private String cook;
   private String customer;
   private boolean flag=true;
   private double income=0f;
   //使用Lock接口下的 ReentreantLock实现类获取一把锁
   Lock lock=new ReentrantLock();

   @Override
   public  void run(){
               for (int i = 1; i <= 20; i++) {
                   synchronized (this) {

                   if (flag) {




                       try {
                       Thread.sleep(1000);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   System.out.println("cook做包子-----");
                   flag=false;
               }
           }
       }


           for(int i=1;i<=20;++i){
               synchronized (this){

               if(!flag){


                   try {
                       Thread.sleep(1000);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   System.out.println("customer吃包子------");
                   flag=true;
               }
           }
       }
   }

    public static void main(String[] args) {
        store store=new store();
        Thread thread=new Thread(store);
        thread.start();
        Thread thread1=new Thread(store);
        thread1.start();
    }

}
