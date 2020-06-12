package com.dongdong.spring.test.getPhone;

import com.dongdong.spring.util.JsonCodecs;
import com.google.gson.JsonObject;
import com.jayway.jsonpath.JsonPath;
import net.dongliu.requests.Requests;
import net.minidev.json.JSONUtil;
import org.junit.Test;

/**
 * @Description:
 * @Date: 2020/6/8  9:22
 * @Author: dongdong
 */
public class GetRegionByIpUtil2 {

    @Test
    public void  getRegion(){
   String  ip="123.125.71.38";
   String result=Requests.get("https://restapi.amap.com/v3/ip?ip="+ip+"&key=48dd01abacbd44d4f78168317975b925").send().readToText();
  // String province= JsonPath.read(result,"$.province");
   Region region=JsonCodecs.jsonToObject(result,Region.class);
   System.out.println(region.getProvince());
    }
}
