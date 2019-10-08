package com.dongdong.spring.test.javaDesignModel7;

import org.springframework.security.core.parameters.P;

/**
 * @Description:
 * @Auther: dongdong
 * @Date: 2019/9/29  15:28
 */
public class men  extends Person {

    public  men(){
       setType("man");
    }
    @Override
    public void address() {
         Clothing clothing=getClothing();
         clothing.personCloth(this);
    }
}
