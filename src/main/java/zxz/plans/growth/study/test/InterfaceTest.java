package zxz.plans.growth.study.test;

/**
 * 接口测试
 *
 * @author zhangxz
 * @date 2019-11-25 11:26
 */

public class InterfaceTest {

    public static void main(String[] args) {
        A a = new A1();
        a.test1();

        A a2 = new A2();
        a2.test1();

    }

    static class A1 implements A {
    }

    static class A2 implements A {
        public void test1() {
            System.out.println("a2.test1 method.");
        }
    }

     interface A {
        default void test1() {
            System.out.println("a.test1 method.");
        }

        int a = 1;
    }

}

