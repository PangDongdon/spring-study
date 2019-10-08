package com.dongdong.spring.test.javaDesignModel15;

/**
 * @Description:
 * @Auther: dongdong
 * @Date: 2019/9/30  17:16
 */
public class SimpleExpression  extends Expression{
    @Override
    void interpret(Context context) {
      System.out.println("这是普解析器");
    }
}
