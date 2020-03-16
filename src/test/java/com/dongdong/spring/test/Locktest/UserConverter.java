package com.dongdong.spring.test.Locktest;

import freemarker.template.utility.StringUtil;
import org.apache.commons.codec.binary.StringUtils;

/**
 *
 * //
 * @Description:
 * @Date: 2019/11/27  16:27
 * @Author: dongdong
 */
public class UserConverter {
    public static ResultDto toDo(User user){
        ResultDto resultDto=new ResultDto();
        resultDto.setUser(user);
        BaseSigntureRequest baseSigntureRequest=ThreadLocalCache.baseSigntureRequestThreadLocal.get();
        String device=baseSigntureRequest.getDevice();
        if(StringUtils.equals(device,"ios")){
            resultDto.setLink("https:www.baidu.com");
        }else{
            resultDto.setLink("https:www.taobao.com");
        }
        return  resultDto;
    }
}
