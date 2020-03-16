package com.dongdong.spring.test.testPackage;

/**
 * @Description:
 * @Date: 2019/12/10  10:17
 * @Author: dongdong
 */
public class GetMaxOrMIn implements  Comparable<GetMaxOrMIn> {

    private  String str;

    public String getStr() {
        return str;
    }

    public GetMaxOrMIn(String str) {
        this.str = str;
    }

    @Override
    public int compareTo(GetMaxOrMIn o) {
        if(this.str.compareTo(o.str)>0){
            return 1;
        }
        return 0;
    }
}
