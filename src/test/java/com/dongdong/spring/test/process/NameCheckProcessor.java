package com.dongdong.spring.test.process;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.util.Set;

/**
 * @Description: 注解处理器
 * @Date: 2019/11/29  18:33
 * @Author: dongdong
 */
@SupportedAnnotationTypes("*")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class NameCheckProcessor  extends AbstractProcessor {

    private NameChecker nameChecker;
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        if(!roundEnv.processingOver()){
            for(Element element: roundEnv.getRootElements()){
                nameChecker.checkNames(element);
            }
        }
        return false;
    }
    @Override
    public void init(ProcessingEnvironment processingEnvironment){
        super.init(processingEnvironment);
        nameChecker=new NameChecker(processingEnv);
    }
}
