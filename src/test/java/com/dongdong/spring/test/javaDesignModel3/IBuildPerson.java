package com.dongdong.spring.test.javaDesignModel3;

/**建造者模式
 * @Description:
 * @Auther: dongdong
 * @Date: 2019/9/25  19:03
 */
public interface IBuildPerson {
     void buildHead();
     void buildFoot();
     Person  bulidPerson();
}
