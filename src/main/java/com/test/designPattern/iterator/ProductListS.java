package com.test.designPattern.iterator;

import java.util.List;

/**
 * Created by szh on 2017/8/28.
 */
//商品数据类：具体聚合类
class ProductListS extends AbstractObjectList {
    public ProductListS(List products) {
        super(products);
    }
    public AbstractIterator createIterator() {
        return new ProductIterator();
    }
    //商品迭代器：具体迭代器，内部类实现
    private class ProductIterator implements AbstractIterator {
        private int cursor1;
        private int cursor2;
        public ProductIterator() {
            cursor1 = 0;
            cursor2 = objects.size() -1;
        }
        public void next() {
            if(cursor1 < objects.size()) {
                cursor1++;
            }
        }
        public boolean isLast() {
            return (cursor1 == objects.size());
        }
        public void previous() {
            if(cursor2 > -1) {
                cursor2--;
            }
        }
        public boolean isFirst() {
            return (cursor2 == -1);
        }
        public Object getNextItem() {
            return objects.get(cursor1);
        }
        public Object getPreviousItem() {
            return objects.get(cursor2);
        }
    }
}

