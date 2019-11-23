package zxz.plans.growth.study.test;

/**
 * 内部类测试
 *
 * @author zhangxz
 * @date 2019-11-22 20:44
 */

public class InnerClassTest {


    public static void main(String[] args){
        // 初始化Bean1
        InnerClassTest innerClassTest = new InnerClassTest();
        Bean1 bean1 = innerClassTest.new Bean1();
        bean1.I++;
        // 初始化Bean2
        Bean2 bean2 = new Bean2();
        bean2.J++;
        //初始化Bean3
        Bean.Bean3 bean3 = new Bean().new Bean3();
        bean3.k++;
    }
    class Bean1{
        public int I = 0;
    }

    static class Bean2{
        public int J = 0;
    }


    static void test1(){
        //局部内部类
        class A{
            int a = 1;
            int b = 2;
        }
        A a = new A();
        System.out.println(a.a);
        System.out.println(a.b);
    }

}

class Bean{
    class Bean3{
        public int k = 0;
    }
}