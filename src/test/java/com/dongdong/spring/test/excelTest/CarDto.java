package com.dongdong.spring.test.excelTest;

import com.github.crab2died.annotation.ExcelField;
import lombok.Data;

/**
 * @Description:
 * @Date: 2020/6/24  14:33
 * @Author: dongdong
 */
@Data
public class CarDto {
    @ExcelField(title = "车牌号")
    private String carNumber;
    @ExcelField(title = "车辆类型")
    private String carType;
}
