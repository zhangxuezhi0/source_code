package zxz.plans.growth.study.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * sdf类测试
 *
 * @author zhangxz
 * @date 2019-11-23 11:25
 */

public class SimpleDateFormatTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException, ParseException {
//        test1();

        SimpleDateFormatTest simpleDateFormatTest = new SimpleDateFormatTest();
        simpleDateFormatTest.test2();

    }

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static ThreadLocal<DateFormat> threadLocal =
            ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

    //线程安全方法
    static Date parse(String string) throws ParseException {
        return threadLocal.get().parse(string);
    }

    void test2() throws ExecutionException, InterruptedException {
        Callable task = () -> {
            //线程安全
            /*SimpleDateFormatTest simpleDateFormatTest = new SimpleDateFormatTest();
            return simpleDateFormatTest.sdf2.parse("2019-01-01 12:13:14");*/

            //线程不安全
//            return sdf.parse("2019-01-01 12:13:14");

            //线程安全
            return parse("2019-01-01 12:13:14");

        };
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future> list = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            Future submit = executorService.submit(task);
            list.add(submit);
        }
        executorService.shutdown();
        for (Future future : list) {
            System.out.println(future.get());
        }
    }

    static {

    }

    //该方法会报错，因为SimpleDateFormat线程不安全，生命为static之后，在多线程使用时会引发线程安全问题
    //java.lang.NumberFormatException: multiple points；For input string: ".200119E.2001194E4"
    //可以把sdf放到ThreadLocal，解决线程安全问题
    static void test1() throws ExecutionException, InterruptedException {
        Callable task = () -> sdf.parse("2019-01-01 12:13:14");
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Future submit = executorService.submit(task);
            list.add(submit);
        }
        executorService.shutdown();
        for (Future future : list) {
            System.out.println(future.get());
        }
    }

}
