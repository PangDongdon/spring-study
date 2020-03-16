package com.dongdong.spring.service.properties;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Date: 2019/11/27  17:53
 * @Author: dongdong
 */
@Configuration
@ConditionalOnClass(GwService.class)//扫描类
@EnableConfigurationProperties(GwProperties.class) //让配置类生效( GwProperties.class)
public class GwAutoConfiguration {

    @Bean
    @ConditionalOnMissingClass
    public GwService gwService(){
        return new GwServiceIml();
    }
}
