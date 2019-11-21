package zxz.plans.growth.study.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

/**
 * 綫程池測試
 *
 * @author zhangxz
 * @date 2019-11-20 15:18
 */

public class ExecutorsTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
//        testSingleThreadExecutor();
//        testScheduledExecutor();
//        testCachedThreadPool();
//        testFixedThreadPool();
//        testSingleThreadScheduledExecutor();

        testWorkStealingPool();

    }

    //TODO 不知道为什么这个方法执行后，无法看到输出结果？？？
    static void testWorkStealingPool(){
        //new ForkJoinPool (Runtime.getRuntime().availableProcessors(),ForkJoinPool.defaultForkJoinWorkerThreadFactory, null, true);
        //核心线程数默认为cpu核数，
        ExecutorService executorService = Executors.newWorkStealingPool(3);
        for (int i = 0; i < 10; i++) {
            TestClasses.T01 t02 = new TestClasses.T01(i + "");
            executorService.submit(t02);
        }
        executorService.shutdown();
    }

    static void testSingleThreadScheduledExecutor(){
        //super(corePoolSize, Integer.MAX_VALUE, 0, NANOSECONDS, new DelayedWorkQueue());
        //其中核心线程数内部指定为1，上限不限制，存活时间为0，队列无界
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        for (int i = 0; i < 10; i++) {
            TestClasses.T02 t02 = new TestClasses.T02();
            scheduledExecutorService.schedule(t02, 1000, TimeUnit.MILLISECONDS);
        }
        scheduledExecutorService.shutdown();
    }

    static void testFixedThreadPool() throws ExecutionException, InterruptedException {
        //new ThreadPoolExecutor(nThreads, nThreads, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
        //核心线程数和上限数是固定且相等的，存活时间为0，队列为无界阻塞的
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 5; i++) {
            TestClasses.T02 t02 = new TestClasses.T02(i+"");
            Future submit = executorService.submit(t02);
//            System.out.println(submit.get());
        }

        executorService.shutdown();
    }

    //乱序执行的
    static void testCachedThreadPool() throws InterruptedException, ExecutionException {
        //new ThreadPoolExecutor(0, Integer.MAX_VALUE,60L, TimeUnit.SECONDS,new SynchronousQueue<Runnable>())
        //核心线程数为0， 上限不限制，存活时间为60秒，队列是无界异步的
        //来多少个任务就创建多少线程去执行，如果有线程执行完任务了，则直接复用
        ExecutorService executorService = Executors.newCachedThreadPool();

        Collection<Callable<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            TestClasses.T02 t02 = new TestClasses.T02(i+"");

            list.add(t02);
            executorService.submit(t02);
        }

        //该方法一次性加入所有任务，并且可以获取所有结果
        List<Future<Integer>> futures = executorService.invokeAll(list);
        for (Future<Integer> future : futures) {
            System.out.println(future.get());
        }

        executorService.shutdown();

    }

    static void testScheduledExecutor() throws InterruptedException {
        //super(corePoolSize, Integer.MAX_VALUE, 0, NANOSECONDS, new DelayedWorkQueue());
        //从构造方法可知，核心线程数通过参数指定，而线程数上限不限制，存活时间为0，队列是无界的
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);

        long currentTimeMillis = System.currentTimeMillis();
        //每个周期里面要完成的工作，是执行完毕加入线程池的所有任务，如果在一个周期之内完成不了所有任务，则定时器就会丧失定时效果。
        for (int i = 0; i < 5; i++) {
            TestClasses.T01 t01 = new TestClasses.T01();
            //延迟一定时间后，才开始执行任务
//            executorService.schedule(t01, 1000, TimeUnit.MILLISECONDS);

            //按照固定时间间隔执行任务，从任务执行任务开始的时刻，开始计时
//            executorService.scheduleAtFixedRate(t01, 0, 10000,TimeUnit.MILLISECONDS);

            //按照固定时间间隔执行任务，从任务执行任务完毕的时刻，开始计时
            executorService.scheduleWithFixedDelay(t01, 0, 5000, TimeUnit.MILLISECONDS);

        }

        //使用scheduleAtFixedRate 或者 scheduleWithFixedDelay时，shutdown的效果相当于shutdownNow，aka马上关闭线程池
//        executorService.shutdown();


        while (!executorService.isTerminated()) {
        }
        System.out.println(System.currentTimeMillis() - currentTimeMillis);

    }

    static void testSingleThreadExecutor() {
        //new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
        //由其构造方法可知，该线程池中，核心线程数为1，线程数量上限也是1，线程存活时间为0，队列是无界的。
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        baseTest(executorService);

    }

    static void baseTest(ExecutorService executorService) {
        long currentTimeMillis = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            TestClasses.T02 b = new TestClasses.T02(i+"");
            executorService.submit(b);
        }
        executorService.shutdown();
        while (!executorService.isTerminated()) {
        }
        System.out.println(System.currentTimeMillis() - currentTimeMillis);
    }

}
