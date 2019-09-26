package test_threadpool测试线程池;

/**
 * 死锁演示
 */
public class LockThread implements Runnable {

    private boolean flag;

    LockThread(boolean flag) {
        this.flag = flag;
    }


    @Override
    public void run() {
            if(flag){
                while (true){
                    synchronized (MyLock.object1){
                        System.out.println(Thread.currentThread().getName()+ ".....if object1 " );
                        synchronized (MyLock.object2){
                            System.out.println(Thread.currentThread().getName()+ ".....if object2 " );
                        }
                    }
                }
            }else {
                while (true){
                    synchronized (MyLock.object2){
                        System.out.println(Thread.currentThread().getName()+ ".....else object2 " );
                        synchronized (MyLock.object1){
                            System.out.println(Thread.currentThread().getName()+ ".....else object1 " );
                        }
                    }
                }

            }
    }
}

class MyLock {
    static Object object1 = new Object();
    static Object object2 = new Object();

}

class TestThread{

    public static void main(String[] args) {
        Thread thread1 = new Thread(new LockThread(true));
        Thread thread2 = new Thread(new LockThread(false));
        thread1.start();
        thread2.start();
    }
}