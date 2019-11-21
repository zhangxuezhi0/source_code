package zxz.plans.growth.study.test;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.LongAdder;

/**
 * 测试类
 *
 * @author zhangxz
 * @date 2019-11-19 15:50
 */

public class ThreadLocalTest {

    public static void main(String[] args) throws InterruptedException {

        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("zxz");

        for (int i = 0; i < 3; i++) {
            new Thread(()->{
                incInt();
            }).start();
        }

    }

    private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);

    static void incInt(){
        for (int i = 0; i < 5; i++) {

            threadLocal.set(threadLocal.get()+1);
            System.out.println(Thread.currentThread().getName() + ": "+ threadLocal.get());
            Thread.yield();
        }
    }

}
