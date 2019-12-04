package zxz.plans.growth.study.test;

/**
 * 继承测试
 *
 * @author zhangxz
 * @date 2019-11-25 10:31
 */

public class ExtendsTest {

    public static void main(String[] args) {
        A1C a1C = new A1C();
        /*a1C.printa();

        A1 a1 = new A1C();
        a1.printa();

        A1 a11 = new A1();
        a11.printa();*/
    }


}

class A1C extends A1{
    A1C(){
        System.out.println("a1c constructor. ");
        System.out.println("c: " + c);
        System.out.println(super.a1);
    }
    private int c = 121;
    private Fie fie = new Fie("a1c");

    static int d = 133;
    static{
        System.out.println("static of a1c, d: " + d);
    }

    @Override
     void printa(){
        super.printa();
        System.out.println("a in a1c");
    }

}

class A1{

    private Fie fie = new Fie("a1");
     void printa(){
        System.out.println("a in a1");
    }

    A1(){
        System.out.println("constructor of a1");
        System.out.println("b: " + b);
    }

    private int b = 3;

    int a1 = 3;


    private static int a = 13;
    static {
        System.out.println("static of a1, a: "+ a);
    }
}

class Fie{
    Fie(String name){
        System.out.println(name + " fie constructor.");
    }
}