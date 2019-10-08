package com.dongdong.spring.test.javaDesignModel19;

/**
 * @Description:
 * @Auther: dongdong
 * @Date: 2019/10/8  11:53
 */
public class Test {
    public static void main(String[] args) {
        Policeman policeman = new HuangPuPolice();
        Citizen citizen = new HuangPuCitizen(policeman);
        citizen.sendMwssage("unnormal");
    }
}
