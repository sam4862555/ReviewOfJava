package com.test.designPattern.bridge;

/**
 * Created by szh on 2017/8/22.
 */
public abstract class Image {
    protected ImageImp imp;
    public void setImageImp(ImageImp imp) {
        this.imp = imp;
    }
    public abstract void parseFile(String fileName);
}