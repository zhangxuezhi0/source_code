package zxz.plans.growth.study.test;

import first.zxz.tools.PrintTool;

import java.time.ZoneId;
import java.util.TimeZone;

/**
 * 时区类测试
 *
 * @author zhangxz
 * @date 2019-11-23 15:38
 */

public class TimeZoneTest {

    public static void main(String[] args) {
        test1();
    }

    static void test1(){
//        PrintTool.printStringArr(TimeZone.getAvailableIDs());
        System.out.println(ZoneId.systemDefault());
        System.out.println(ZoneId.getAvailableZoneIds());
        System.out.println(ZoneId.SHORT_IDS);
    }

}
