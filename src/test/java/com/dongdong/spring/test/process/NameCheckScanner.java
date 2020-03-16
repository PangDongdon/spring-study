package com.dongdong.spring.test.process;

import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.ElementScanner8;

/**
 * @Description:
 * @Date: 2019/11/29  18:58
 * @Author: dongdong
 */
public class NameCheckScanner extends ElementScanner8<Void,Void> {

    //检查java类
    public Void visitType(TypeElement element, Void p){
        scan(element.getTypeParameters(),p);
        checkCamelCase(element,true);
        super.visitType(element,p);
        return null;
    }


    String s="{\"ips\": [\"10.20.30.40\"], \"appId\": \"4016\", \"appKey\": \"840A6E9FBC03F4107FFF2400ADFE1855\", \"appName\": \"代理商\", \"methods\": [\"O0001\", \"O0002\", \"O0003\", \"O0004\", \"O0006\", \"O0008\", \"O0010\", \"O0011\", \"O0012\", \"O0013\", \"O0014\", \"O0015\", \"O0016\", \"O0017\", \"O0018\", \"O0019\", \"O0020\", \"O0021\", \"O0025\", \"O0009\", \"N0012\", \"O0026\", \"O0027\", \"O0028\", \"O0029\", \"O0030\", \"O0031\", \"O0032\", \"O0033\", \"O0034\", \"O0035\", \"O0036\", \"O0037\", \"N0099\", \"SOOO1\"], \"bussineTypes\": \"chaiqit\", \"zhaoyouCompanyIds\": [\"1398\"]}";
    //检查传入的Element是否符合驼峰式命名，若不符合，输出警告信息
    private void checkCamelCase(Element e,boolean initialCaps){
        String name=e.getSimpleName().toString();
        boolean previousUpper=false;
        boolean conventional=true;
        int firstCodePoint=name.codePointAt(0);
        if(Character.isUpperCase(firstCodePoint)){
            previousUpper=true;
            if(! initialCaps){

            }
        }


    }

    //大写命名检查，要求第一个字母必须是大写的英文字母，其余部分可以是下划线或大写
    private void checkAllCaps(Element e){
        String name=e.getSimpleName().toString();

    }

}
