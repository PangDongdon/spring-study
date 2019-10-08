package com.dongdong.spring.test.javaDesignModel15;

/**
 * @Description:
 * @Auther: dongdong
 * @Date: 2019/9/30  17:17
 */
public class AdvanceExpression extends  Expression {
    @Override
    void interpret(Context context) {
        System.out.println("这是高级解析器");
    }
}
