package com.dongdong.spring.test.javaDesignModel19;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Auther: dongdong
 * @Date: 2019/10/8  11:15
 */
public abstract class Citizen {

    List<Policeman> pols;
    String help ="normal";

    public String getHelp() {
        return help;
    }

    public void setHelp(String help) {
        this.help = help;
    }

    abstract  void sendMwssage(String help);

    public void setPoliceman(){
        pols=new ArrayList();
    }

    public void register(Policeman pol){
        this.pols.add(pol);
    }
    public void unRegister(Policeman pol){
        this.pols.remove(pol);
    }
}
