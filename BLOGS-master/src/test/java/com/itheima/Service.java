package com.itheima;

import com.itheima.util.JedisUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisDataException;

public class Service {
    String id;
    Long num;
    public Service(String id,Long num){
        this.id=id;
        this.num=num;
    }

    //控制单元
    public void service( ){
        Jedis jedis=new JedisUtils().getJedis();
        String value=jedis.get("compid:"+id);
        //判断该值是否存在
        try{
            if(value==null){
                //不存在  创建
                //顺便设置过期时间
                jedis.setex("compid:"+id,10,Long.MAX_VALUE-num+"");
            }else{
                //存在    自增
                   Long l= jedis.incr("compid:"+id);
                    b(id,l);
            }
        }catch (JedisDataException e) {
            System.out.println("使用已经达到次数上限，请升级会员级别");
            return;
        }finally {
            jedis.close();
        }

    }

    //业务
    public void b(String id,Long l){
        System.out.println("用户："+id+"  业务调用:"+(num-(Long.MAX_VALUE-l)));
    }
}

class MyThread extends Thread{
    Service sc;
    public MyThread(String id,Long num){
        sc=new Service(id,num);
    }

    public void run(){
        while(true){
            sc.service();
            try{
                Thread.sleep(300L);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

class Main{
    public static void main(String[] args) {
        MyThread mt=new MyThread("初级用户",10L);
        MyThread mt2=new MyThread("高级用户",30L);
        mt.start();
        mt2.start();
    }
}