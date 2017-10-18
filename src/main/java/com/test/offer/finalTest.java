package com.test.offer;

/**
 * Created by szh on 2017/9/18.
 */
class finalTest {
    final  protected void test(){
        System.out.println("11111");
    }

    protected void  test(int a){

    }
}

class ext extends  finalTest {
//    protected void test(){
//        System.out.println("11111");
//    }
}
class zzz extends  ext{
    protected void test(int b){

    }
}
