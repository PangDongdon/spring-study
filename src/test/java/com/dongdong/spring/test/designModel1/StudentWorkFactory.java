package com.dongdong.spring.test.designModel1;

import org.junit.Test;

/**
 * @Description:
 * @Auther: dongdong
 * @Date: 2019/9/25  15:45
 */
public class StudentWorkFactory implements IWorkFactory {
    @Override
    public Work dowork() {
        return new TeacherWork();
    }


    @Test
    public void work(){
       new StudentWorkFactory().dowork().work();
       new TeacherWorkFactory().dowork().work();
    }


}


