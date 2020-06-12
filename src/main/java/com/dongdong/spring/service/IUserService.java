package com.dongdong.spring.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Description:
 * @Date: 2020/3/16  10:29
 * @Author: dongdong
 */

public interface IUserService {
    /**读取excel数据生成list*/
    String readExcelFile(MultipartFile file);
}
