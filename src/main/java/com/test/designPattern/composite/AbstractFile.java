package com.test.designPattern.composite;

/**
 * Created by szh on 2017/8/22.
 */
//抽象文件类：抽象构件
abstract class AbstractFile {

    public abstract void add(AbstractFile file);

    public abstract void remove(AbstractFile file);

    public abstract AbstractFile getChild(int i);

    public abstract void killVirus();
}