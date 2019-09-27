package com.itwei.Thread线程;


/**
 * (守护线程demo)  设置主线程为守护线程 主线程挂掉之后 子线程也跟着挂
 *
 *
 * join()方法作用
 * join作用是让其他线程变为等待,
 * t1.join();// 让其他线程变为等待，直到当前t1线程执行完毕，才释放。
 * thread.Join把指定的线程加入到当前线程，可以将两个交替执行的线程合并为顺序执行的线程。
 * 比如在线程B中调用了线程A的Join()方法，直到线程A执行完毕后，才会继续执行线程B
 */
public class TheadDemo守护线程 {
    public static void main(String[] args) {
        final Thread thread = new Thread(new Runnable(){

            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("子线程......");
                }
            }
        });
        //设置守护线程
        thread.setDaemon(true);
        thread.start();

        for(int i=0;i<10;i++){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("主线程......"+ i);
        }
        System.out.println("主线程执行结束了......");
    }
}
