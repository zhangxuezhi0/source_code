package zxz.plans.growth.study.test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 死锁测试
 *
 * @author zhangxz
 * @date 2019-11-21 17:54
 */

public class DeadLockTest {
    public static void main(String[] args) {
        DeadLockTest test = new DeadLockTest();
        new Thread(() -> {
            try {
                test.test3();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                test.test4();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }

    private static ReentrantLock lock1 = new ReentrantLock();
    private static ReentrantLock lock2 = new ReentrantLock();

    public void test3() throws InterruptedException {
        System.out.println("method test3");

        lock1.lock();
        System.out.println("t3 lock1");

        TimeUnit.SECONDS.sleep(2);

        lock2.lock();
        System.out.println("t3 lock2");

        lock2.unlock();
        System.out.println("t3 unlock2");

        lock1.unlock();
        System.out.println("t3 unlock1");
    }


    public void test4() throws InterruptedException {
        System.out.println("method test4");

        lock2.lock();
        System.out.println("t4 lock2");

        TimeUnit.SECONDS.sleep(2);

        lock1.lock();
        System.out.println("t4 lock1");

        lock1.unlock();
        System.out.println("t4 unlock1");

        lock2.unlock();
        System.out.println("t4 unlock2");
    }


}
