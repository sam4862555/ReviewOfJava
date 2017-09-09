package com.test.designPattern.command.basicCommand;

/**
 * Created by szh on 2017/8/26.
 */
//帮助命令类：具体命令类
class HelperCommand extends Command {
    private HelpHandler hhObj; //维持对请求接收者的引用
    public HelperCommand() {
        hhObj = new HelpHandler();
    }
    //命令执行方法，将调用请求接收者的业务方法
    public void execute() {
        hhObj.display();
    }
}