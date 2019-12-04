package zxz.plans.growth.study.test;

/**
 * 多态测试
 *
 * @author zhangxz
 * @date 2019-11-24 21:49
 */

public class PolymorphicTest {

    public static void main(String[] args) {
        test4();
    }

    private static void test4() {
        A a1 = new A();
        A a2 = new B();
        B b = new B();

        System.out.println(a1 instanceof A);
        System.out.println(a1 instanceof B);

        System.out.println(a2 instanceof A);
        System.out.println(a2 instanceof B);

        System.out.println(b instanceof A);
        System.out.println(b instanceof B);
    }

    private static void test3() {
        A a1 = new A();
        A a2 = new B();

        B b = new B();
        C c = new C();
        D d = new D();

        //b and a
        System.out.println(a2.show(a1));
        //b and a
        System.out.println(a2.show(a2));
        //b and a
        System.out.println(a2.show(b));
        //b and a
        System.out.println(a2.show(c));
        //a and d
        System.out.println(a2.show(d));

        //b and a
        System.out.println(b.show(a1));
        //b and a
        System.out.println(b.show(a2));
        //b and b
        System.out.println(b.show(b));
        //b and b
        System.out.println(b.show(c));
        //a and d
        System.out.println(b.show(d));

    }


    static void test2(){
        A a1 = new A();
        A a2 = new B();

        B b = new B();
        C c = new C();
        D d = new D();

        //a and a
        System.out.println(a1.show(b));
        //a and a
        System.out.println(a1.show(c));
        //a and d
        System.out.println(a1.show(d));

        //b and a，
        //原理，调用时，首先定位到a类的show(A a)方法，
        // 然后运行时发现实际是b类，并且b类覆写了该方法，所以调用了b类覆写的方法show(A a)
        System.out.println(a2.show(b));
        //b and a
        System.out.println(a2.show(c));
        //a and d
        System.out.println(a2.show(d));

        //b and b
        System.out.println(b.show(b));
        //b and b
        System.out.println(b.show(c));
        //a and d
        System.out.println(b.show(d));
    }

    static void test1(){
        E e = new E();
        A a = new E();
        B b = new B();
        D d = new D();

        //a and a
        System.out.println(e.show(a));
        //b and e
        System.out.println(e.show(b));
        //a and d
        System.out.println(e.show(d));

        //a and a
        System.out.println(a.show(a));
        //a and a
        System.out.println(a.show(b));
        //a and d
        System.out.println(a.show(d));
    }

}

class E extends A{
    String show(B b){
        return "b and e";
    }
}

class A{
    String show(A a){
        return "a and a";
    }

    String show(D d){
        return "a and d";
    }

}

class B extends A{
    String show(B b){
        return "b and b";
    }
    String show(A a){
        return "b and a";
    }
}

class C extends B{}

class D extends B{}