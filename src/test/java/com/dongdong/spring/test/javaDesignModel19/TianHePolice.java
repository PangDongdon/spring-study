package com.dongdong.spring.test.javaDesignModel19;

/**
 * @Description:
 * @Auther: dongdong
 * @Date: 2019/10/8  11:31
 */
public class TianHePolice implements  Policeman {
    @Override
    public void action(Citizen ci){
        String help=ci.getHelp();
         if("normal".equals(help)){
             System.out.println("一切正常");
         }
         if("unnormal".equals(help)){
             System.out.println("有犯罪行为，天河警察出动");
         }
    }
}
