package zxz.plans.growth.study.test;

import java.util.concurrent.TimeUnit;

/**
 * sleep方法测试
 *
 * @author zhangxz
 * @date 2019-11-21 18:40
 */

public class SleepTest {

    public static void main(String[] args) throws InterruptedException {

    }



    static void test11(){
        new Thread(()->{
            try {
                test1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                test1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    //sleep的时候，不会释放锁
    static synchronized void test1() throws InterruptedException {
        long l = System.nanoTime();
        Thread.sleep(1000, 900000);
        System.out.println(Thread.currentThread().getName() + " have been waiting for 1 second");
        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.println(Thread.currentThread().getName() + " waiting end.");
        System.out.println(System.nanoTime() -l);
    }

}
