package com.dongdong.spring.service;

import com.dongdong.spring.Application;
import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.model.CityResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.net.InetAddress;

/** 通过ip获取区域信息
 * @Description:
 * @Date: 2020/6/5  10:57
 * @Author: dongdong
 */
@Slf4j
@Service
public class GetRegionByIpUtil {
    @Autowired
    private Environment environment;
    private static String dbPath = "/usr/local/GeoLite2-City.mmdb";
    private static DatabaseReader reader;


    //@PostConstruct
    public void init() {
        try {
            String path = environment.getProperty("geolite2.city.db.path");
            if (StringUtils.isNotBlank(path)) {
                dbPath = path;
            }
            File database = new File(dbPath);
            reader = new DatabaseReader.Builder(database).build();
        } catch (Exception e) {
            log.error("IP地址服务初始化异常:" + e.getMessage(), e);
        }
    }
    @Test
    public void test(){
        init();
        String ipAddress="192.168.63.25";
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
