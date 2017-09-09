package com.test.offer;

/**
 * Created by szh on 2017/8/28.
 */
class InheritPrivilege {
    public void test(){
        System.out.println("test");
    }
}

class InheritPrivilegeSubClass extends InheritPrivilege{

    @Override
    public void test(){
        System.out.println("test");
    }
}