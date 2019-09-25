package test_threadpool;

public class ThreadSpeakUntil {
    String name;
    String sex;
    boolean flag;

}

/**
 * 写入操作
 * <p>
 * 想要操作这个对象就把它传入进来
 */
class input implements Runnable {
    private ThreadSpeakUntil ThreadSpeakUntil;

    public input(ThreadSpeakUntil ThreadSpeakUntil) {
        this.ThreadSpeakUntil = ThreadSpeakUntil;
    }

    @Override
    public void run() {

        int i = 0;
        while (true) {
            synchronized (ThreadSpeakUntil) {
                if (ThreadSpeakUntil.flag) {
                    try {
                        ThreadSpeakUntil.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (i == 0) {
                    ThreadSpeakUntil.name = "小红";
                    ThreadSpeakUntil.sex = "女";
                } else {
                    ThreadSpeakUntil.name = "小明";
                    ThreadSpeakUntil.sex = "男";
                }
                i = (i + 1) % 2;
                ThreadSpeakUntil.flag = true;
                ThreadSpeakUntil.notify();
            }
        }
    }
}

class ReadInput implements Runnable {

    private ThreadSpeakUntil ThreadSpeakUntil;

    public ReadInput(ThreadSpeakUntil ThreadSpeakUntil) {
        this.ThreadSpeakUntil = ThreadSpeakUntil;
    }

    @Override
    public void run() {

        while (true) {
            synchronized (ThreadSpeakUntil) {
                if (!ThreadSpeakUntil.flag) {
                    try {
                        ThreadSpeakUntil.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("name " + ThreadSpeakUntil.name + " " + "sex " + ThreadSpeakUntil.sex);
                ThreadSpeakUntil.flag = false;
                ThreadSpeakUntil.notify();
            }
        }
    }
}

class TestSpeakThread {

    public static void main(String[] args) {

        ThreadSpeakUntil ThreadSpeakUntil = new ThreadSpeakUntil();
        input ip = new input(ThreadSpeakUntil);
        ReadInput rp = new ReadInput(ThreadSpeakUntil);
        Thread thread1 = new Thread(ip);
        Thread thread2 = new Thread(rp);
        thread1.start();
        thread2.start();

    }
}