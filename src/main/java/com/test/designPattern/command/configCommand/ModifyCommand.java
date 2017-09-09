package com.test.designPattern.command.configCommand;

/**
 * Created by szh on 2017/8/26.
 */
//修改命令类：具体命令
class ModifyCommand extends Command {
    public ModifyCommand(String name) {
        super(name);
    }
    public void execute(String args) {
        this.args = args;
        configOperator.modify(args);
    }
    public void execute() {
        configOperator.modify(this.args);
    }
}
