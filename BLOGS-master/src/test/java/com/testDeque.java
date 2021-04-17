package com;

//外部类
public class testDeque {
    int num=100;

    //内部类
    class A{
        int num=10;
        public void put(){
            int num=1;
            System.out.println("inner");
            //num为方法中的    为了区分，使用 类名.this.变量名
            System.out.println(num+" "+this.num+" "+testDeque.this.num);
        }

        public void put2(){
            final int a=1;
//          局部内部类
            class B{
                public void put(){
//                  只能使用方法final的变量，不能改变
                    System.out.println(a);
                }
            }
        }
    }

//    Good接口
//    public interface Good {
//        int put(int a);
//    }

    public static void main(String[] args) {
        //匿名内部类实现接口
        Good good1 = new Good() {
            @Override
            public int put(int a) {
                return a;
            }
        };

        //lambda表达式简化匿名内部类  ()->{  }
        Good good2=(int a)->{ return a; };

        //lambda表达式单个参数简写方式
        Good good=a->{ return a; };

//------------------------------------------------
        //装箱
        Integer integer1 = Integer.valueOf(1);

        //自动装箱
        Integer integer=1;
        //拆箱
        int a=integer.intValue();
        //Integer转String
        String s = integer.toString();
        System.out.println(s+1);
        //11

        //转int
        int aa=Integer.parseInt(s);
        System.out.println(aa+1);
        //2
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("good");
            }
        }).start();

    }
}
