package com.dongdong.spring.test.designModel1;

/**
 * @Description:
 * @Auther: dongdong
 * @Date: 2019/9/25  15:46
 */
public class TeacherWorkFactory implements IWorkFactory {
    @Override
    public Work dowork() {
        return new StudentWork();
    }
}
