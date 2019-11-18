package com.dongdong.spring.service;

import com.dongdong.spring.dao.PersonDao;

/**
 * @Description:
 * @Date: 2019/11/15  9:24
 * @Author: dongdong
 */
public class StudentImpl implements PersonDao {
    @Override
    public void say() {
        System.out.println("student");
    }
}
