package com.dongdong.spring.test.DesignMode.commandPattern;

/**
 * @Description:
 * @Date: 2020/8/27  9:40
 * @Author: dongdong
 */
public class BuyStock implements  Order {
    private Stock  stock;

    public BuyStock(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void execute() {
       stock.buy();
    }
}
