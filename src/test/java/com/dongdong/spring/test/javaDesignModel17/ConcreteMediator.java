package com.dongdong.spring.test.javaDesignModel17;

/**
 * @Description:
 * @Auther: dongdong
 * @Date: 2019/10/8  10:22
 */
public class ConcreteMediator  extends  Mediator{
   private  ColleagueA ca;
   private ColleagueB cb;
   public ConcreteMediator(){
       ca=new ColleagueA();
       cb=new ColleagueB();
   }
    @Override
    public void notice(String content) {
        if("boss".equals(content)){
             ca.action();
        }
        if("client".equals(content)){
            cb.action();
        }
    }
}
