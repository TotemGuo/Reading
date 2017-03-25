package test;

/**
 * Created by Holmes on 2016/10/15.
 */
class MyThread implements Runnable {
    int num = 1000000;
    public void run() {
        if (Thread.currentThread().getName().equals("t1")) {
            increment();
        } else {
            decrement();
        }
    }

    public void increment() {
        for (int i = 0; i < 100000; i++) {
            num++;
        }
    }

    public void decrement() {
        for (int i = 0; i < 100000; i++) {
            num--;
        }
    }
}

public class Test {

    public static void main(String[] args) {
        MyThread thread = new MyThread();
        Thread a = new Thread(thread, "t1");
        Thread b = new Thread(thread, "t2");

        a.start();
        b.start();

        try {
            a.join();
            b.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(thread.num);
    }
}