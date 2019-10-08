package com.dongdong.spring.test.javaDesignModel19;

/**
 * @Description:
 * @Auther: dongdong
 * @Date: 2019/10/8  11:31
 */
public class TianHeCitizen extends  Citizen {
    public TianHeCitizen(Policeman policeman) {
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
