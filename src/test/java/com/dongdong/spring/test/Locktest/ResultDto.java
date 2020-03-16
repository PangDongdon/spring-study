package com.dongdong.spring.test.Locktest;

import lombok.Data;

/**
 * @Description:
 * @Date: 2019/11/27  16:20
 * @Author: dongdong
 */
@Data
public class ResultDto {
    private int code;
    private int message;
    private  User user;
    private String link;
}
