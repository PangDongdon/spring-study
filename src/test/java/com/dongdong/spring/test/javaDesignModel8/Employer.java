package com.dongdong.spring.test.javaDesignModel8;

import lombok.Data;

import java.util.List;

/**
 * @Description:
 * @Auther: dongdong
 * @Date: 2019/9/29  16:34
 */
@Data
public abstract  class Employer {
    private String name;
    public  List emeploters;

    public List  getEmeploters() {
        return  this.emeploters;
    }

    public abstract  void  deleteElmployer(Employer employer);

    public abstract  void addEmployer(Employer employer);

    public void  printlnInfo(){
        System.out.println(name);
    }
}
