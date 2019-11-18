package zxz.plans.growth.study.test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 指令重排序测试
 *
 * @author zhangxz
 * @date 2019-11-17 16:40
 */

public class CmdReorderTest {

    private static int a = 0;
    private static int b = 0;
    private static int c = 0;
    private static int d = 0;
    private static int e = 0;
    private static int f = 0;
    private static int g = 0;
    private static int h = 0;

/*
    private static volatile int a = 0;
    private static volatile int b = 0;
    private static volatile int c = 0;
    private static volatile int d = 0;
    private static volatile int e = 0;
    private static volatile int f = 0;
    private static volatile int g = 0;
    private static volatile int h = 0;
*/

    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 500000; i++) {
            //join可以保证线程a b都执行完成之后，再继续下一次循环
            ThreadA threadA = new ThreadA();
            threadA.start();

            ThreadB threadB = new ThreadB();
            threadB.start();

            threadA.join();
            threadB.join();

            //清空数据，便于测试
            a = 0;
            b = 0;
            c = 0;
            d = 0;
            e = 0;
            f = 0;
            g = 0;
            h = 0;
        }
    }

    static class ThreadA extends Thread {
        @Override
        public void run() {
            synchronized (lock) {
                a = 1;
                b = 1;
                c = 1;
                d = 1;
                e = 1;
                f = 1;
                g = 1;
                h = 1;
            }
        }
    }

    static class ThreadB extends Thread {
        @Override
        public void run() {
            synchronized (lock) {
                if (b == 1 && a == 0) {
                    System.out.println("b=1");
                }
                if (c == 1 && (a == 0 || b == 0)) {
                    System.out.println("c=1");
                }
                if (d == 1 && (a == 0 || b == 0 || c == 0)) {
                    System.out.println("d=1");
                }
                if (e == 1 && (a == 0 || b == 0 || c == 0 || d == 0)) {
                    System.out.println("e=1");
                }
                if (f == 1 && (a == 0 || b == 0 || c == 0 || d == 0 || e == 0)) {
                    System.out.println("f=1");
                }
                if (g == 1 && (a == 0 || b == 0 || c == 0 || d == 0 || e == 0 || f == 0)) {
                    System.out.println("g=1");
                }
                if (h == 1 && (a == 0 || b == 0 || c == 0 || d == 0 || e == 0 || f == 0 || g == 0)) {
                    System.out.println("h=1");
                }
            }
        }
    }

}
