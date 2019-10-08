package com.dongdong.spring.test.javaDesignModel23;

/**
 * @Description:
 * @Auther: dongdong
 * @Date: 2019/10/8  14:53
 */
public class StringElement implements  Visitable {
    private String  se;

    public StringElement(String se) {
        this.se = se;
    }

    public String getSe() {
        return se;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitString(this);
    }
}
