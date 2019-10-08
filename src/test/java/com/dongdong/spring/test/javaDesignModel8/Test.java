package com.dongdong.spring.test.javaDesignModel8;

import java.util.List;

/** 组合模式
 * @Description:
 * @Auther: dongdong
 * @Date: 2019/9/29  16:42
 */
public class Test {

    public  static  void main(String[] args){
         Employer  programmer=new Programmer("程序员1");
         Employer projectAssitant=new ProjectAssitant("助理商1");
         Employer  projectManager=new ProjectManager("项目经理");
         projectManager.addEmployer(programmer);
         projectManager.addEmployer(projectAssitant);
         List  Empolyers=  projectManager.getEmeploters();
         for(Object  e: Empolyers){
              Employer a=(Employer)e;
              System.out.println(a.getName());
         }
    }
}
