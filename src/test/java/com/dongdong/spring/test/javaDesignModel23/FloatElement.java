package com.dongdong.spring.test.javaDesignModel23;

/**
 * @Description:
 * @Auther: dongdong
 * @Date: 2019/10/8  14:54
 */
public class FloatElement implements Visitable {
    private Float fe;
    public  FloatElement(Float fe){
        this.fe=fe;
    }

    public Float getFe() {
        return fe;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitFsloat(this);
    }
}
