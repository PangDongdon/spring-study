package com.dongdong.spring.test.synchronizedCallback;

/**
 * @Description:
 * @Date: 2020/7/1  13:51
 * @Author: dongdong
 */
public interface OrderResult {
     /**
      *订单货物状态
      * @param state
      * @return
      */
    String getOrderResult(String state);
}
