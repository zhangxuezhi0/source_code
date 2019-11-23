package zxz.plans.growth.study.test;

/**
 * final关键字的测试
 *
 * @author zhangxz
 * @date 2019-11-22 20:11
 */

public class FinalTest {

    public static void main(String[] args) {
        final int a;
        a = 1;
        //final变量不能被修改
//        a = 2;
    }

    class A {
        final void a(){}
    }

    class D extends A{
        //final 方法不能被重写
//        void a(){}
        void b(){}
    }



    final class B extends A {
        void b(){}
        final void c(){}
    }


    //final class 不能被继承
//    class C extends B{}


}
