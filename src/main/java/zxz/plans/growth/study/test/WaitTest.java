package zxz.plans.growth.study.test;

import java.util.concurrent.TimeUnit;

/**
 * wait方法测试
 *
 * @author zhangxz
 * @date 2019-11-21 18:51
 */

public class WaitTest {

    public static void main(String[] args) throws InterruptedException {
        WaitTest.test3();
    }

    private static final Object lock = new Object();

    static void test3() throws InterruptedException {
        Thread thread = newSyncThread();
        TimeUnit.SECONDS.sleep(2);

        printThread(thread);
        thread.interrupt();
        TimeUnit.SECONDS.sleep(1);
        printThread(thread);


    }

    static void printThread(Thread thread){
        System.out.println("==========print thread");
        System.out.println(thread.getName());
        System.out.println(thread.getPriority());
        System.out.println(thread.getContextClassLoader());
        System.out.println(thread.getUncaughtExceptionHandler());
        System.out.println(thread.getState());
        System.out.println(thread.isAlive());
        System.out.println(thread.isDaemon());
        System.out.println(thread.isInterrupted());
    }

    static Thread newSyncThread() {
        Thread thread = new Thread(() -> {
            try {
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() + " start waiting");
                    //调用wait时，会释放锁，这样其他线程才能使用该锁重新调用wait方法，notifyAll才有了存在的价值
                    lock.wait();
                    System.out.println(Thread.currentThread().getName() + " waiting end.");
                }
            } catch (InterruptedException e) {
                System.out.println("中断异常：" + e.getMessage());
                e.printStackTrace();
            }
        });
        thread.start();
        return thread;
    }

    static void test2() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            newSyncThread();
        }

        TimeUnit.SECONDS.sleep(1);

        new Thread(() -> {
            synchronized (lock) {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                /*System.out.println("notify");
                lock.notify();*/

                System.out.println("notify all");
                lock.notifyAll();
            }
        }).start();
    }

    /**
     * 该方法会抛出异常：IllegalMonitorStateException
     * 因为wait方法必须要在synchronized代码块或方法中调用，才能持有锁
     * <p>
     * 注意：即使使用ReentrantLock加锁，也同样会抛出异常，不知道为什么。
     *
     * @return void
     * @throws InterruptedException
     * @author zhangxz
     * @date 2019/11/21 19:05
     */
    /*synchronized*/
    static void test1() throws InterruptedException {
        System.out.println("method test2");
        WaitTest.class.wait(1000);
        System.out.println("method test2 end.");
    }


}
