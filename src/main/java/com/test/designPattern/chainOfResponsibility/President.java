package com.test.designPattern.chainOfResponsibility;

/**
 * Created by szh on 2017/8/25.
 */
//董事长类：具体处理者
class President extends Approver {
    public President(String name) {
        super(name);
    }
    //具体请求处理方法
    public void processRequest(PurchaseRequest request) {
        if (request.getAmount() < 500000) {
            System.out.println("董事长" + this.name + "审批采购单：" + request.getNumber() + "，金额 : " + request.getAmount()); }
        else {
            this.successor.processRequest(request); //转发请求
        }
    }
}