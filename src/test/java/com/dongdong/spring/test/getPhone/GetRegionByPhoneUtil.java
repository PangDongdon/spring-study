package com.dongdong.spring.test.getPhone;

import com.github.crab2died.ExcelUtils;
import com.github.crab2died.exceptions.Excel4JException;
import com.jayway.jsonpath.JsonPath;
import net.dongliu.requests.Requests;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/** 解析号码获取归属地工具类
 * @Description:
 * @Date: 2020/6/4  18:21
 * @Author: dongdong
 */

public class GetRegionByPhoneUtil {
    @Test
    public void getPhoneMsg() throws IOException, Excel4JException, InvalidFormatException {
        //获取excel 中的所有数据
        List<Phone1> phoneList = ExcelUtils.getInstance().readExcel2Objects("D:\\testPhone.xlsx", Phone1.class);
        //获取所有电话号码
        List<String> phones = phoneList.stream().distinct().map(p -> p.getPhone()).collect(Collectors.toList());
        //System.out.println(phones);
        List<Phone> data=Lists.newArrayList();
        //根据号码获取区域并导出
        phones.forEach(p -> {
            try {
                String result = Requests.get("http://tcc.taobao.com/cc/json/mobile_tel_segment.htm?tel=" + p).send().readToText();
                String replace = result.replace("__GetZoneResult_ = ", "");
                String province = JsonPath.read(replace, "$.province");
               // String city=JsonPath.read(replace,"$.city");
               // System.out.println(province);
               // Thread.sleep(1000L);
                Phone  phone=new Phone();
                phone.setProvince(province);
                phone.setPhone(p);
              //  phone.setCity(city);
                data.add(phone);
               // System.out.println(data);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        ExcelUtils.getInstance().exportObjects2Excel(data, Phone.class, "D:\\phone1.xlsx");
    }
}
