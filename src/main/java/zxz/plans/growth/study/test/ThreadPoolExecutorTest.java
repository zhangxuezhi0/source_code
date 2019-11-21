package zxz.plans.growth.study.test;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 测试类
 *
 * @author zhangxz
 * @date 2019-11-19 20:02
 */

public class ThreadPoolExecutorTest {

    public static void main(String[] args) {

        long currentTimeMillis = System.currentTimeMillis();

        //有界队列
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(20);

        //无界队列
//        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();

        //任务处理策略：拒绝任务并且抛出异常，默认采用该策略
        ThreadPoolExecutor.AbortPolicy abortPolicy = new ThreadPoolExecutor.AbortPolicy();
        //任务处理策略：拒绝任务，但是不抛出异常
        ThreadPoolExecutor.DiscardPolicy discardPolicy = new ThreadPoolExecutor.DiscardPolicy();
        //任务处理策略：把队列里等待最久的任务抛弃，然后把新的任务加入队列尾部。
        ThreadPoolExecutor.DiscardOldestPolicy discardOldestPolicy = new ThreadPoolExecutor.DiscardOldestPolicy();
        //任务处理策略：让调用者自己执行该任务，
        ThreadPoolExecutor.CallerRunsPolicy callerRunsPolicy = new ThreadPoolExecutor.CallerRunsPolicy();

        ThreadPoolExecutor executorService =
                new ThreadPoolExecutor(3, 10, 3000, TimeUnit.MILLISECONDS, arrayBlockingQueue, discardPolicy);


        //允许销毁核心线程
        executorService.allowCoreThreadTimeOut(true);

        try {
            for (int i = 0; i < 32; i++) {
                try {
                    A a = new A();
                    executorService.execute(a);
//                    executorService.submit(a);

                    /*B b = new B();
                    Future submit = executorService.submit(b);*/
                    printPoolStatus(executorService);

                    //直接调用Future的get方法会阻塞在这里，直到该任务执行完成
//                    System.out.println("result: " + submit.get());

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } finally {
//            executorService.shutdown();
        }

        //该线程用来检测线程池并定时输出线程池状态
        new Thread(() -> {
            while (!executorService.isTerminated()) {

                System.out.println("*************************************");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                printPoolStatus(executorService);
            }
            System.out.println((System.currentTimeMillis() - currentTimeMillis));

        }).start();


        System.out.println("game over!");

/*
        //通过submit提交任务，可以获取返回值，通过该返回值可以拿到返回数据，同时也可以捕获到异常
        //当然，如果不调用返回的Future数据的get方法，异常不会在这个线程出现
        Future<?> submit = executorService.submit(new C());
        try{
            System.out.println("submit result: " + submit.get());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
*/

    }

    static void printPoolStatus(ThreadPoolExecutor executorService) {
        System.out.print(", [0]执行任务中的线程数量" + executorService.getActiveCount());
        System.out.print(", [1]完成的任务数量" + executorService.getCompletedTaskCount());
        System.out.print(", [2]核心线程大小" + executorService.getCorePoolSize());
        System.out.print(", [3]???" + executorService.getLargestPoolSize());
        System.out.print(", [4]池最大容量" + executorService.getMaximumPoolSize());
        System.out.print(", [5]池中存在的线程数量" + executorService.getPoolSize());
        System.out.print(", [6]总任务数量" + executorService.getTaskCount());
        System.out.print(", [7]队列中任务数量" + executorService.getQueue().size());
//        System.out.println();
//        System.out.print(", [8]队列中任务详情" + executorService.getQueue());
        System.out.println("==============");
    }

    static class A implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + " run method.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class B implements Callable {
        static Random random = new Random();

        @Override
        public Object call() throws Exception {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " call method.");
            return random.nextInt();
        }
    }

    static class C implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                System.out.println("awake!");
                throw new RuntimeException("抛出异常测试！");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
