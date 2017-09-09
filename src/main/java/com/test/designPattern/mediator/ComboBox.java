package com.test.designPattern.mediator;

/**
 * Created by szh on 2017/8/28.
 */
//组合框类：具体同事类
class ComboBox extends Component {
    public void update() {
        System.out.println("组合框增加一项：张无忌。");
    }
    public void select() {
        System.out.println("组合框选中项：小龙女。");
    }
}
