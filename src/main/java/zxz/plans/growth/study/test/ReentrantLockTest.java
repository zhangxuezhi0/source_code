package zxz.plans.growth.study.test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁测试
 *
 * @author zhangxz
 * @date 2019-11-21 21:49
 */

public class ReentrantLockTest {

    public static void main(String[] args) throws InterruptedException {
        test8();
    }

    private static ReentrantLock reentrantLock = new ReentrantLock();
    private static ReentrantLock reentrantLock2 = new ReentrantLock(true);

    private static volatile boolean threadRunning = false;

    //该测试以失败告终，本来打算用一个例子来分别使用公平锁和非公平锁，使之表现出不同的效果
    static void test8() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            final int a = i;

            threadRunning = false;
            Thread thread = new Thread(() -> {
                threadRunning = true;
                reentrantLock2.lock();
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.print(Thread.currentThread().getName() + " ");
                if (a % 10 == 0) {
                    System.out.println();
                }
                reentrantLock2.unlock();
            }, "" + i);

            thread.start();
            //自旋直到线程开始运行
//            while (!threadRunning) {}

        }

    }


    static void test7() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                boolean b = false;
                try {
                    b = reentrantLock.tryLock(2000, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " try lock: " + b);
                if (b) {
                    try {
                        TimeUnit.MILLISECONDS.sleep(0);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    reentrantLock.unlock();
                    System.out.println(Thread.currentThread().getName() + " unlock ");
                }
            }).start();
        }
    }

    static void test6() {
        for (int i = 0; i < 2; i++) {

            new Thread(() -> {
                reentrantLock.lock();
                System.out.println(Thread.currentThread().getName() + " lock");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                reentrantLock.unlock();
                System.out.println(Thread.currentThread().getName() + " unlock");
            }).start();
        }

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {

                boolean b = reentrantLock.tryLock();
                System.out.println(Thread.currentThread().getName() + " try lock: " + b);
                if (b) {
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    reentrantLock.unlock();
                    System.out.println(Thread.currentThread().getName() + " unlock ");
                }
            }).start();
        }
    }

    static void test4() {
        test5();
        reentrantLock.lock();
        test5();
        reentrantLock.lock();
        test5();
        reentrantLock.unlock();
        test5();
        reentrantLock.unlock();
        test5();

    }

    static void test5() {
        System.out.println("=======method test5 ");
        System.out.println(reentrantLock.getQueueLength());
        System.out.println(reentrantLock.getHoldCount());
        System.out.println(reentrantLock.hasQueuedThreads());
        System.out.println(reentrantLock.isFair());
        System.out.println(reentrantLock.isLocked());
        System.out.println(reentrantLock.isHeldByCurrentThread());
    }

    static void test3() throws InterruptedException {
        System.out.println("method test3");
        System.out.println(Thread.currentThread().getName() + " lock and sleep");

        System.out.println("hold count: " + reentrantLock.getHoldCount());
        reentrantLock.lock();
        System.out.println("hold count: " + reentrantLock.getHoldCount());
        reentrantLock.lock();
        System.out.println("hold count: " + reentrantLock.getHoldCount());
        reentrantLock.lock();
        System.out.println("hold count: " + reentrantLock.getHoldCount());

//        test1();

        reentrantLock.unlock();
        System.out.println("hold count: " + reentrantLock.getHoldCount());
        reentrantLock.unlock();
        System.out.println("hold count: " + reentrantLock.getHoldCount());
        reentrantLock.unlock();
        System.out.println("hold count: " + reentrantLock.getHoldCount());

        System.out.println(Thread.currentThread().getName() + " unlock");
    }

    static void test2() {
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                try {
                    test1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    static void test1() throws InterruptedException {
        reentrantLock.lock();
        System.out.println(Thread.currentThread().getName() + " lock and sleep");
        TimeUnit.MILLISECONDS.sleep(1500);
        reentrantLock.unlock();
        System.out.println(Thread.currentThread().getName() + " unlock");
    }

}
