package com.itwei.Thread线程;

/**
 * 线程 join 的用法
 *
 * 有T1 T2 T3   规则 T3在T2 之后执行 T2 在T1 之后执行
 */
public class ThreadT1 implements Runnable{

    @Override
    public void run() {
        for(int i =0;i<30;i++){
            System.out.println("T1 线程"+Thread.currentThread().getId());
        }
    }

}
 class ThreadT2 implements Runnable{

    @Override
    public void run() {
        for(int i =0;i<30;i++){
            System.out.println("T2 线程"+Thread.currentThread().getId());
        }
    }
}

class ThreadT3 implements Runnable{

    @Override
    public void run() {
        for(int i =0;i<30;i++){
            System.out.println("T3 线程"+Thread.currentThread().getId());
        }
    }
}

class TestJion{
    public static void main(String[] args) {
        ThreadT1 t1 =new ThreadT1();
        ThreadT2 t2 = new ThreadT2();
        ThreadT3 t3 =new ThreadT3();
        Thread thread1 = new Thread(t1);
        Thread thread2 = new Thread(t2);
        Thread thread3 = new Thread(t3);
        thread1.start();
        thread2.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread3.start();
        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
