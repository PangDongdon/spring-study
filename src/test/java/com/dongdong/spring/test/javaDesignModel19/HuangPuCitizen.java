package com.dongdong.spring.test.javaDesignModel19;

/**
 * @Description:
 * @Auther: dongdong
 * @Date: 2019/10/8  11:30
 */
public class HuangPuCitizen extends Citizen {

    public HuangPuCitizen(Policeman policeman) {
        setPoliceman();
        register(policeman);
    }

    @Override
    void sendMwssage(String help){
        setHelp(help);
        for(int i=0;i<pols.size();i++){
            Policeman policeman=pols.get(i);
            policeman.action(this);
        }
    }
}
