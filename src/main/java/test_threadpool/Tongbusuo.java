package test_threadpool;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 演示线程安全问题，引入一个业务需求，火车站现在有100张票，现在有两个窗口同时抢火车票，实现这段代码。
 */
public class Tongbusuo implements Runnable{
    // 定义线程共享数据
        private int i=100;
        private Object object = new Object();
//run 方法是线程需要执行的代码 业务逻辑
    @Override
    public void run() {
        // TODO：死循环，暂不处理
        while (true){
           synchronized (object){
               if (i>0){
                   try {
                       Thread.sleep(100);
                       System.out.println("当前线程 "+ Thread.currentThread().getName()+"-----"+  i--);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }

               }
           }

        }
    }
}
class ThreadDemo{

    public static void main(String[] args) {
        System.out.println("当前线程 "+ Thread.currentThread().getName());
        //开启两个线程，共享数据t=100，执行run方法中的代码：当t大于0时，打印t--
        Tongbusuo tongbusuo =  new Tongbusuo();
        Thread thread1 = new Thread(tongbusuo);
        Thread thread2 = new Thread(tongbusuo);
        thread1.start();
        thread2.start();
    }
}
