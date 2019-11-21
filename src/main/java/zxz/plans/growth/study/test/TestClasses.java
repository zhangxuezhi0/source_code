package zxz.plans.growth.study.test;

import first.zxz.tools.DateUtil;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 * 测试用类
 *
 * @author zhangxz
 * @date 2019-11-20 17:02
 */

public class TestClasses {

    static class T01 extends T00 implements Runnable {
        public T01() {
        }

        public T01(String name) {
            super(name);
        }

        @Override
        public void run() {
            baseTest(this);
        }
    }


    static class T02 extends T00 implements Callable {
        public T02() {
        }

        public T02(String name) {
            super(name);
        }

        @Override
        public Object call() throws Exception {
            baseTest(this);
            return random.nextInt();
        }
    }

    static class T00 {
        private String name;

        public T00() {
        }

        public T00(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }
    }

    private static void baseTest(T00 t00) {
        try {
            String name = Thread.currentThread().getName();
            if(t00!=null){
                name += "#" + t00.getName() + " ";
            }

            System.out.println(name + " 任务执行开始时间 " + DateUtil.getNow(DateUtil.DATE_TIME_MILLI_FORMAT_1));
            Thread.sleep(1000);
            System.out.println(name + " 任务执行结束时间 " + DateUtil.getNow(DateUtil.DATE_TIME_MILLI_FORMAT_1));

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void baseTest() {
        baseTest(null);
    }

    private static Random random = new Random();

}
