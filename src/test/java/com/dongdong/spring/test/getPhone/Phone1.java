package com.dongdong.spring.test.getPhone;

import com.github.crab2died.annotation.ExcelField;
import lombok.Data;

/**
 * @Description:
 * @Date: 2020/6/8  16:49
 * @Author: dongdong
 */
@Data
public class Phone1 {
    @ExcelField(title = "司机手机号")
    private String phone;
    @ExcelField(title = "油品名称")
    private String oilName;
}
