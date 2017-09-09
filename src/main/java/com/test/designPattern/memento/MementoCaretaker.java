package com.test.designPattern.memento;

/**
 * Created by szh on 2017/8/28.
 */
//象棋棋子备忘录管理类：负责人
class MementoCaretaker {
    private ChessmanMemento memento;
    public ChessmanMemento getMemento() {
        return memento;
    }
    public void setMemento(ChessmanMemento memento) {
        this.memento = memento;
    }
}
