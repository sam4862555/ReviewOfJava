package com.test.lambda;


class AlreadyExist {
    public static void MM(Integer a) {
        System.out.println("通过类的静态函数引用 数据是 :" + a);
    }

    public void KK(Integer b) {
        System.out.println("通过类的非静态函数引用 数据是 :" + b * b);
    }

}

@FunctionalInterface
interface Cmd {
    void DoSomething(Integer data);
}

interface DefaultCmd {

    default void DefaultMethod(Integer data) {
        System.out.println("接口的默认函数 输出是: " + data);
    }
}

/**
 * Created by szh on 2017/8/7.
 */
public class FuncQuote {

    public static void main(String[] args) {
        Cmd a = (n) -> System.out.println("通过lambda表达式 数据是 :" + n);
        a.DoSomething(5);

        Cmd b = AlreadyExist::MM;
        b.DoSomething(5);

        AlreadyExist s = new AlreadyExist();
        Cmd c = s::KK;
        c.DoSomething(5);

        DefaultCmd defaultCmd = new DefaultCmd() {
        };
        Cmd d = defaultCmd::DefaultMethod;
        d.DoSomething(5);
    }

}
