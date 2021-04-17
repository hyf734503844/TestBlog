package com.itheima;

import redis.clients.jedis.Jedis;

import java.util.Random;

public class JedisTest {
    public void testJedis(){
        //1.连接redis
        Jedis jedis=new Jedis("127.0.0.1",6379);
        //2.操作redis
        jedis.set("name","hyf");
        //3。关闭
        jedis.close();
    }
    public static String randomCode() {
        StringBuilder str = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            str.append(random.nextInt(10));
        }
        return str.toString();

    }
    public static void main(String[] args) {

//        jedis.set("name","hyf");

//        System.out.println(jedis.get("name"));
//        jedis.lpush("list1","1","2","3");
//        jedis.rpush("list1","x");
//        List<String> list=jedis.lrange("list1",0,-1);
//        for (String s:list){
//            System.out.println(s);
//        }
//        System.out.println(jedis.llen("list1"));
//        System.out.println(list.size());

        //1.连接redis
        Jedis jedis=new Jedis("127.0.0.1",6379);

        //2.操作redis
        //获取id 转String
        //调一个随机6位数字方法
        jedis.setex("testtime",300, randomCode());
//
        //3。关闭
        jedis.close();
    }
}
