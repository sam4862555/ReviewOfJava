package com.test.designPattern.command.configCommand;

import java.io.Serializable;

/**
 * Created by szh on 2017/8/26.
 */
//配置文件操作类：请求接收者。由于ConfigOperator类的对象是Command的成员对象，它也将随Command
class ConfigOperator implements Serializable {
    public void insert(String args) {
        System.out.println("增加新节点：" + args);
    }

    public void modify(String args) {
        System.out.println("修改节点：" + args);
    }

    public void delete(String args) {
        System.out.println("删除节点：" + args);
    }
}