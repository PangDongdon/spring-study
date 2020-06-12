package com.dongdong.spring.test.getPhone;

import com.github.crab2died.ExcelUtils;
import com.github.crab2died.exceptions.Excel4JException;
import com.jayway.jsonpath.JsonPath;
import net.dongliu.requests.Requests;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.io.IOException;
import java.sql.ClientInfoStatus;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

/** 线程池解析号码归属地
 * @Description:
 * @Date: 2020/6/9  9:39
 * @Author: dongdong
 */
public class GetRegionByPhoneUtil2 {

    //创建线程池
    ExecutorService executorService = Executors.newFixedThreadPool(4);//创建线程池
    List<String> phones=Lists.newArrayList();
    List<Phone> data= Lists.newArrayList();
    @Test
    public void  getRegionMsg() throws InvalidFormatException, Excel4JException, IOException {
        //获取excel 中的所有数据
        List<Phone1> phoneList = ExcelUtils.getInstance().readExcel2Objects("D:\\testPhone.xlsx", Phone1.class);
        //获取所有电话号码
        phones = phoneList.stream().distinct().map(p -> p.getPhone()).collect(Collectors.toList());
        //变为线程安全的的集合
        // phones= Collections.synchronizedList(phones);
        for(int i=0;i<phones.size();i++) {
            int finalI = i;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    String result = Requests.get("http://tcc.taobao.com/cc/json/mobile_tel_segment.htm?tel=" + phones.get(finalI)).send().readToText();
                    String replace = result.replace("__GetZoneResult_ = ", "");
                    String province = JsonPath.read(replace, "$.province");
                    //String city = JsonPath.read(replace, "$.city");
                    // System.out.println(province);
                    // Thread.sleep(1000L);
                    Phone phone = new Phone();
                    phone.setProvince(province);
                    phone.setPhone(phones.get(finalI));
                  //  phone.setCity(city);
                    data.add(phone);
                }
            };
            //执行任务
            executorService.execute(runnable);

        }
        //任务执行完，导出到excel
        ExcelUtils.getInstance().exportObjects2Excel(data, Phone.class, "D:\\phone3.xlsx");
    }
}
