package com.dongdong.spring.service;

import com.dongdong.spring.dao.PersonDao;

/**
 * @Description:
 * @Date: 2019/11/15  9:04
 * @Author: dongdong
 */
public class PersonImpl implements PersonDao {
   private  PersonDao personDao=null;
   public void setPersonDao(PersonDao  personDao){
       this.personDao=personDao;
   }
    @Override
    public void say() {
       personDao.say();
    }
}
