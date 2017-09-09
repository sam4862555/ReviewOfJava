package com.test.designPattern.command.configCommand;

/**
 * Created by szh on 2017/8/26.
 */
//增加命令类：具体命令
class InsertCommand extends Command {
    public InsertCommand(String name) {
        super(name);
    }
    public void execute(String args) {
        this.args = args;
        configOperator.insert(args);
    }
    public void execute() {
        configOperator.insert(this.args);
    }
}
