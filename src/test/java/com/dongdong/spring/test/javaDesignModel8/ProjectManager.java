package com.dongdong.spring.test.javaDesignModel8;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Auther: dongdong
 * @Date: 2019/9/29  16:42
 */
public class ProjectManager extends  Employer {
    public ProjectManager(String name){
        setName(name);
        emeploters =new ArrayList();
    }


    @Override
    public void deleteElmployer(Employer employer) {
        emeploters.remove(employer);
    }

    @Override
    public void addEmployer(Employer employer) {
        emeploters.add(employer);
    }
}
