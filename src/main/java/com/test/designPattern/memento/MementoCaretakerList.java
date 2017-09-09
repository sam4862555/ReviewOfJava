package com.test.designPattern.memento;


import java.util.*;

/**
 * Created by szh on 2017/8/28.
 */
class MementoCaretakerList {
    //定义一个集合来存储多个备忘录
    private ArrayList mementolist = new ArrayList();
    public ChessmanMemento getMemento(int i) {
        return (ChessmanMemento)mementolist.get(i);
    }
    public void setMemento(ChessmanMemento memento) {
        mementolist.add(memento);
    }
}
