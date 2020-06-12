package com.dongdong.spring.test.getPhone;

import com.github.crab2died.annotation.ExcelField;
import lombok.Data;

/**
 * @Description:
 * @Date: 2020/6/4  18:54
 * @Author: dongdong
 */
@Data
public class Phone {
    @ExcelField(title = "手机号")
    private String phone;
    @ExcelField(title = "省份")
    private String province;
//    @ExcelField(title="城市名")
//    private String city;
}
