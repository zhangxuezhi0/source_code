package zxz.plans.growth.study.test;

/**
 * synchronized关键字测试
 *
 * @author zhangxz
 * @date 2019-11-18 11:07
 */

public class SynchronizedTest {

    private static final Sync sync = new Sync();

    public static void main(String[] args) throws InterruptedException {
        ThreadA threadA1 = new ThreadA();
        ThreadA threadA2 = new ThreadA();
        ThreadB threadB = new ThreadB();

//        testOneRunnable(threadA1);
//        testTwoRunnable(threadA1, threadA2);
        testTwoRunnable(threadA1, threadB);

        {
            /*TestA testA = new TestA();
            testDifferentMethodsInOneObject(testA);*/
        }
    }

    static class Sync {
    }

    static void testDifferentMethodsInOneObject(TestA testA) {
        Runnable runnable1 = () -> {
            try {
                testA.MethodA();
                testA.MethodB();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable runnable2 = () -> {
            try {
                testA.MethodB();
                testA.MethodA();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);

        thread1.start();
        thread2.start();

    }

    static class TestA {
        public synchronized void MethodA() throws InterruptedException {
            Thread.sleep(10);
            System.out.println("process in method a " + Thread.currentThread().getName());
            Thread.sleep(10);
            System.out.println("process in method a " + Thread.currentThread().getName());
            Thread.sleep(10);
            System.out.println("process in method a " + Thread.currentThread().getName());
            Thread.sleep(10);
        }

        public synchronized void MethodB() throws InterruptedException {
            Thread.sleep(10);
            System.out.println("process in method b " + Thread.currentThread().getName());
            Thread.sleep(10);
            System.out.println("process in method b " + Thread.currentThread().getName());
            Thread.sleep(10);
            System.out.println("process in method b " + Thread.currentThread().getName());
            Thread.sleep(10);
        }
    }

    //使用一个runnable对象，在两个不同线程调用
    static void testOneRunnable(Runnable runnable) {
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);

        thread1.start();
        thread2.start();
    }

    //使用两个runnable对象，在两个不同线程调用
    static void testTwoRunnable(Runnable runnable1, Runnable runnable2) {
        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);

        thread1.start();
        thread2.start();
    }

    static class ABParent {
    }

    static class ThreadA/* extends ABParent */ implements Runnable {
        @Override
        public void run() {
//            synchronized (this) {
//            synchronized (ThreadA.class) {
//            synchronized (ABParent.class) {
            synchronized (sync) {
                try {
                    Thread.sleep(10);
                    System.out.println("process in thread a " + Thread.currentThread().getName());
                    Thread.sleep(10);
                    System.out.println("process in thread a " + Thread.currentThread().getName());
                    Thread.sleep(10);
                    System.out.println("process in thread a " + Thread.currentThread().getName());
                    Thread.sleep(10);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }

        }
    }

    static class ThreadB /*extends ABParent*/ implements Runnable {
        @Override
        public void run() {
//            synchronized (this) {
//            synchronized (ThreadB.class) {
//            synchronized (ABParent.class) {
            synchronized (sync) {
                try {
                    Thread.sleep(10);
                    System.out.println("process in thread b " + Thread.currentThread().getName());
                    Thread.sleep(10);
                    System.out.println("process in thread b " + Thread.currentThread().getName());
                    Thread.sleep(10);
                    System.out.println("process in thread b " + Thread.currentThread().getName());
                    Thread.sleep(10);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }


}
