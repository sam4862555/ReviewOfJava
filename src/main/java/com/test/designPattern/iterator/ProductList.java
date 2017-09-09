package com.test.designPattern.iterator;

import java.util.List;

/**
 * Created by szh on 2017/8/28.
 */
//商品数据类：具体聚合类
class ProductList extends AbstractObjectList {
    public ProductList(List products) {
        super(products);
    }
    //实现创建迭代器对象的具体工厂方法
    public AbstractIterator createIterator() {
        return new ProductIterator(this);
    }
}