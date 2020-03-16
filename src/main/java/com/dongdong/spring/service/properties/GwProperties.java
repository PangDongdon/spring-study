package com.dongdong.spring.service.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Date: 2019/11/27  17:51
 * @Author: dongdong
 */
@Component
@Data
@ConfigurationProperties(prefix ="spring.gwname")
public class GwProperties {
    String name="dongdong";


}
