package com.dongdong.spring.test.ManyThreads;

import com.dongdong.spring.test.getPhone.Phone;
import com.dongdong.spring.test.getPhone.Phone1;
import com.github.crab2died.ExcelUtils;
import com.github.crab2died.exceptions.Excel4JException;
import com.jayway.jsonpath.JsonPath;
import net.dongliu.commons.Sys;
import net.dongliu.requests.Requests;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.assertj.core.util.Lists;
import org.springframework.web.servlet.tags.EditorAwareTag;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Date: 2020/6/9  14:06
 * @Author: dongdong
 */
public class Test {
   static  ExecutorService executorService = Executors.newFixedThreadPool(8);//创建线程池
   static List<String> phones= Lists.newArrayList();
   static  List<Phone> data= Lists.newArrayList();
    public static void main(String[] args) throws InvalidFormatException, Excel4JException, IOException, ExecutionException, InterruptedException {

        //获取excel 中的所有数据
        List<Phone1> phoneList = ExcelUtils.getInstance().readExcel2Objects("D:\\手机号分析.xlsx", Phone1.class);
        //获取所有电话号码
        phones = phoneList.stream().distinct().map(p -> p.getPhone()).collect(Collectors.toList());
        List<Phone> data = phones.parallelStream().map(Test::call).collect(Collectors.toList());
       // System.out.println(collect);
        // for(int i=0;i<10;i++) {
//        Task task=null;
      /*  for(int i=0;i<phones.size();i++) {
            FutureTask<Phone> futureTask=new FutureTask<>(new Task(phones.get(i)));
            executorService.submit(futureTask);
//           new Thread(futureTask).start();
            data.add(futureTask.get());
        }
        executorService.shutdown();*/


      //  }
        ExcelUtils.getInstance().exportObjects2Excel(data, Phone.class, "D:\\phone2.xlsx");
    }

     static Phone call(String phone1) {
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
