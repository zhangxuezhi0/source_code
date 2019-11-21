package zxz.plans.growth.study.test;

/**
 * synchronized测试类2
 *
 * @author zhangxz
 * @date 2019-11-18 21:43
 */

public class SynchronizedTest2 {

    public static void main(String[] args) {
        TestA testA = new TestA();
        new Thread(() -> {
            testA.a();
        }).start();

        new Thread(() -> {
            testA.b();
        }).start();
    }

    static class TestA {
        static synchronized void a() {

            System.out.println("i am method a.");
            Thread.yield();
            System.out.println("i am method a.");
            Thread.yield();
            System.out.println("i am method a.");
        }

        synchronized void b() {

            System.out.println("i am method b.");
            Thread.yield();
            System.out.println("i am method b.");
            Thread.yield();
            System.out.println("i am method b.");
        }
    }

}
