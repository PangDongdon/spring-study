package com.dongdong.spring.test.javaDesignModel15;

/**
 * @Description:
 * @Auther: dongdong
 * @Date: 2019/9/30  17:22
 */
public class Test {
    public static void main(String[] args){
         Context c=new Context();
         c.add(new SimpleExpression());
         c.add(new AdvanceExpression());
         for(Expression e:c.getList()){
             e.interpret(c);
         }
    }
}
