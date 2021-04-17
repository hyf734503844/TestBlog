package com;

import java.util.HashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("all")
interface myInterface{
    void myFunction();
}

class Person1{
    public  Integer id;
    public String personname;
    public  Integer age;


    public Person1(Integer id, String personname, Integer age) {
        this.id = id;
        this.personname = personname;
        this.age = age;
    }
}


@Deprecated
@SuppressWarnings("All")
class A extends Thread{

    @Override
    public void run(){

    }

    Integer integer=1;

    class AA{
        Integer integer=11;

        public  void print(){
            System.out.println(this.integer);
            System.out.println(A.this.integer);
            class printA{
                Integer integer=111;
            }
            System.out.println(1);
        }

    }

    public static void main(String[] args) {
        AA aa= new A().new AA();
        A a=new A();
        System.out.println(aa.integer);
        System.out.println(a.integer);

    }
}

class BB extends A{

}

public class testAll {
    public static Integer cnt=1;

    static{
        cnt++;

    }
    public static void main(String[] args) throws Exception {
        HashMap hashMap1=new HashMap();
        Executor executor = Executors.newCachedThreadPool();
//        executor.execute(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("1");
//            }
//        });

        Executor executor1=Executors.newFixedThreadPool(5);

        Executor executor2=Executors.newSingleThreadExecutor();

        Executor executor3=Executors.newScheduledThreadPool(5);

        Executor executor4=Executors.newFixedThreadPool(10);

        Executor executor5=Executors.newCachedThreadPool();

        Executor executor6=Executors.newSingleThreadExecutor();

        Executor executor7=Executors.newScheduledThreadPool(5);

        Executor executor8=Executors.newSingleThreadExecutor();

        Executor executor9=Executors.newFixedThreadPool(5);

        Executor executor10=Executors.newCachedThreadPool();

        ScheduledExecutorService executor11=Executors.newScheduledThreadPool(5);

        while(true)
        executor11.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("1");
            }
        },5, TimeUnit.MICROSECONDS);

        //        testAll testAll = new testAll();
//        testAll testAll2 = new testAll();
//        System.out.println(testAll2.cnt);

//        int a;
//        long la;
//        short sa;
//        float f;
//        double lf;
//        char c;
//        boolean b;
//        byte  be;
//
//        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
//        objectObjectHashMap.put(1,1);
//        objectObjectHashMap.put(2,20);
//        objectObjectHashMap.put(3,3);
//        // 迭代键
//        for (Object key : objectObjectHashMap.keySet()) {
//            System.out.println("Key = " + key);
//        }
//
//        // 迭代值
//        for (Object value : objectObjectHashMap.values()) {
//            System.out.println("Value = " + value);
//
//        }
//            Iterator
//
//            A a=new A();
//            BB bb=new BB();
//

//        Queue queue=new LinkedList();
//        ArrayList<Person1> arrayList=new ArrayList<>();
//        arrayList.add(new Person1(10,"HYF",22));
//        arrayList.add(new Person1(1,"QQ",10));
//        arrayList.add(new Person1(5,"XXX",50));
//        Vector vector=new Vector();
//        ConcurrentHashMap concurrentHashMap=new ConcurrentHashMap();
//        HashSet hashSet=new HashSet();
//        Collections.sort(arrayList, new Comparator<Person1>() {
//            @Override
//            public int compare(Person1 o1, Person1 o2) {
//                return o1.id-o2.id;
//            }
//        });
//        for(Person1 person1:arrayList){
//            System.out.println(person1.personname);
//        }
//        Class aClass = A.AA.class;
////        System.out.println(aClass.getName().toString());
////        System.out.println(new A().new AA().getClass().getName());
//        Class<?> aClass1 = Class.forName("com.A");
////        System.out.println(aClass1.getName().toString());
//
//        Method print = aClass.getMethod("print");
//
//        Object invoke = print.invoke(aClass.newInstance());
//
//
//        Integer integer;
//        String s;
    }
    static{
        cnt++;

    }
}


