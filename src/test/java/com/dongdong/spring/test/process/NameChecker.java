package com.dongdong.spring.test.process;

import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;

/**
 * @Description:
 * @Date: 2019/11/29  18:37
 * @Author: dongdong
 */
public class NameChecker {

    private final Messager messager;
    NameCheckScanner nameCheckScanner=new NameCheckScanner();

    public NameChecker(Messager messager) {
        this.messager = messager;
    }

    NameChecker(ProcessingEnvironment processingEnvironment){
        this.messager=processingEnvironment.getMessager();
    }
    public void checkNames(Element element){

    }
}
