package zxz.plans.growth.study.test;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.List;

/**
 * 测试类
 *
 * @author zhangxz
 * @date 2019-11-24 16:17
 */

public class Test {

    public static void main(String[] args) {
        Object object = new Object();

    }

    static void test2(String string){
        System.out.println(string);
    }

    static void test1(){
        List<GarbageCollectorMXBean> garbageCollectorMXBeans = ManagementFactory.getGarbageCollectorMXBeans();
        for (GarbageCollectorMXBean collectorMXBean : garbageCollectorMXBeans) {
            System.out.println(collectorMXBean.getName());
        }
    }

}
