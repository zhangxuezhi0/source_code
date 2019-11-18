package zxz.plans.growth.study.test;

import java.util.ArrayList;
import java.util.List;

/**
 * 线程的join方法测试
 * 结论：join方法是保证该线程完成了，才会执行后续的步骤
 *
 * @author zhangxz
 * @date 2019-11-17 16:54
 */

public class ThreadJoinTest {

    public static void main(String[] args) throws InterruptedException {
//        withJoin();
//        withoutJoin();

        executeNotInOrder();

    }

    //start和join两个步骤分开，效果：子线程间交替执行，所有完成之后，再执行主线程
    static void executeNotInOrder() throws InterruptedException {
        List<Thread> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            ThreadA threadA1 = new ThreadA("00" + i);
            threadA1.start();
            list.add(threadA1);
        }
        for (Thread thread : list) {
            thread.join();
        }

    }

    //没有使用join，主线程和子线程之间，是交替这执行的，先后顺序无法保证
    static void withoutJoin() {
        for (int i = 0; i < 10; i++) {
            ThreadA threadA = new ThreadA("" + i);
            threadA.start();
        }
    }

    //在每个子线程start之后，都调用其join方法，则主线程会等待子线程执行完成之后，再继续执行后面的步骤。按照顺序执行的
    static void withJoin() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            ThreadA threadA = new ThreadA("" + i);
            threadA.start();
            threadA.join();
        }
    }

    private static class ThreadA extends Thread {
        public ThreadA(String name) {
            super(name);
        }

        public ThreadA() {
        }

        @Override
        public void run() {
            System.out.println("I am thread a. " + Thread.currentThread().getName());
        }
    }

}
