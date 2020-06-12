package com.dongdong.spring.test.ManyThreads;

import com.dongdong.spring.test.getPhone.Phone;
import com.jayway.jsonpath.JsonPath;
import net.dongliu.requests.Requests;

import java.util.List;
import java.util.concurrent.Callable;

/**
 * @Description:
 * @Date: 2020/6/9  14:05
 * @Author: dongdong
 */
public class Task implements Callable<Phone> {
    public String  phone1;


    public Task(String phone1) {
        this.phone1 = phone1;
    }

    @Override
    public  Phone call() {
        String result = Requests.get("http://tcc.taobao.com/cc/json/mobile_tel_segment.htm?tel=" + phone1).send().readToText();
        String replace = result.replace("__GetZoneResult_ = ", "");
        String province = JsonPath.read(replace, "$.province");
       // String city = JsonPath.read(replace, "$.city");
        // System.out.println(province);
        // Thread.sleep(1000L);
        Phone phone = new Phone();
        phone.setProvince(province);
        phone.setPhone(phone1);
       // phone.setCity(city);
        return phone;
    }
}
