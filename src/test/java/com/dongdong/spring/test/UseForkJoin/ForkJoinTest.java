package com.dongdong.spring.test.UseForkJoin;

import com.dongdong.spring.test.getPhone.Phone;
import com.dongdong.spring.test.getPhone.Phone1;
import com.github.crab2died.ExcelUtils;
import com.github.crab2died.exceptions.Excel4JException;
import com.jayway.jsonpath.JsonPath;
import net.dongliu.requests.Requests;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.assertj.core.util.Lists;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Description:
 * @Date: 2020/6/8  18:05
 * @Author: dongdong
 */
public   class ForkJoinTest {
    private final static int threshold=3;
    public static    List<Phone> data= Lists.newArrayList();
    public static   List<String> phones=Lists.newArrayList();
    public static void main(String[] args) throws InvalidFormatException, Excel4JException, IOException {
        List<Phone1> phoneList = ExcelUtils.getInstance().readExcel2Objects("D:\\订单导出.xlsx", Phone1.class);
        //获取所有电话号码
         phones = phoneList.stream().distinct().map(p -> p.getPhone()).collect(Collectors.toList());
        //分而治之
        final ForkJoinPool  pool= new ForkJoinPool();
        ForkJoinTask<List<Phone>> result=pool.submit(new MyRecursiveTask(0,phones.size()));
        try{
           System.out.println(result.get());
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    static class MyRecursiveTask extends RecursiveTask<List<Phone>>{
       private  final int start;
       private final  int end;

       private MyRecursiveTask(int start, int end) {
           this.start = start;
           this.end = end;
       }

       @Override
       protected List<Phone> compute() {
           //如果任务过小则进行计算
           if(end-start<threshold){
               for(int i=start;i<end;i++) {
                   String result = Requests.get("http://tcc.taobao.com/cc/json/mobile_tel_segment.htm?tel=" + phones.get(i)).send().readToText();
                   String replace = result.replace("__GetZoneResult_ = ", "");
                   String province = JsonPath.read(replace, "$.province");
                   String city = JsonPath.read(replace, "$.city");
                   // System.out.println(province);
                   // Thread.sleep(1000L);
                   Phone phone = new Phone();
                   phone.setProvince(province);
                   phone.setPhone(phones.get(i));
                 //  phone.setCity(city);
                   data.add(phone);
               }
           return data;
           }else {
               int mid=(start+end)/2;
               MyRecursiveTask leftTask=new MyRecursiveTask(start,mid);
               MyRecursiveTask rightTask=new MyRecursiveTask(mid,end);
               leftTask.fork();
               rightTask.fork();
               return  leftTask.join();
           }
       }
   }

}
