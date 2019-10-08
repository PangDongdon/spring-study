package com.dongdong.spring.test.javaDesigModel2;

/** 抽象工厂
 * @Description:
 * @Auther: dongdong
 * @Date: 2019/9/25  17:41
 */
public class BlackAnimalFaceory implements IAnimalFactory {
    @Override
    public ICat createCat() {
        return new BlackCat();
    }

    @Override
    public IDog createDog() {
        return new BlackDog();
    }
}
