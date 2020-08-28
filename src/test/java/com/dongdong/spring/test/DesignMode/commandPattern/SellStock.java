package com.dongdong.spring.test.DesignMode.commandPattern;

/**
 * @Description:
 * @Date: 2020/8/27  9:41
 * @Author: dongdong
 */
public class SellStock implements  Order {
    private Stock stock;

    public SellStock(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void execute() {
      stock.sell();
    }
}
