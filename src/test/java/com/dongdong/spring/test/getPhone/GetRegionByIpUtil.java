package com.dongdong.spring.test.getPhone;

import com.dongdong.spring.ApplicationTests;
import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.model.CityResponse;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

/** 通过ip获取区域信息
 * @Description:
 * @Date: 2020/6/5  10:57
 * @Author: dongdong
 */
@Slf4j
public class GetRegionByIpUtil {

    @Test
    public void test() throws IOException {
        String ipAddress="128.101.101.101";
        // 创建 GeoLite2 数据库
        File database = new File("E:\\GeoLite2-City.mmdb");
        // 读取数据库内容
        DatabaseReader reader = new DatabaseReader.Builder(database).build();
        try {
            CityResponse response = reader.city(InetAddress.getByName(ipAddress));
            String province=response.getMostSpecificSubdivision().getNames().get("zh-CN");
            String city=response.getCity().getNames().get("zh-CN");
            log.info("省份信息为:{},城市名称为：{}",province,city);
        }catch (Exception e){
            log.error("根据IP[{}]获取省份失败:{}", ipAddress, e.getMessage());

    }
}
}
