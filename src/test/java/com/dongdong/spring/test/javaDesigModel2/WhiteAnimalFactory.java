package com.dongdong.spring.test.javaDesigModel2;

/**
 * @Description:
 * @Auther: dongdong
 * @Date: 2019/9/25  17:45
 */
public class WhiteAnimalFactory  implements  IAnimalFactory{
    @Override
    public ICat createCat() {
        return new WhiteCat();
    }

    @Override
    public IDog createDog() {
        return new WhiteDog();
    }
}
