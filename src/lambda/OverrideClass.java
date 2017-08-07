package lambda;

/**
 * Created by szh on 2017/8/7.
 */
interface InterfaceA1 {
    default void foo() {
        System.out.println("InterfaceA foo");
    }

    default void bar() {
        System.out.println("InterfaceA bar");
    }
}

abstract class AbstractClassA {
    public abstract void foo();

    public void bar() {
        System.out.println("AbstractClassA bar");
    }
}

class ClassA1 extends AbstractClassA implements InterfaceA1 {
    @Override
    public void foo() {
        InterfaceA1.super.foo();
    }
}

public class OverrideClass{
    public static void main(String[] args) {
        ClassA1 classA = new ClassA1();
        classA.foo(); // 打印：“InterfaceA foo”
        classA.bar(); // 打印：“AbstractClassA bar”
    }
}