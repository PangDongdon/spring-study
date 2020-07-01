package com.dongdong.spring.test.excelTest;

import com.github.crab2died.ExcelUtils;
import com.github.crab2died.exceptions.Excel4JException;
import net.dongliu.commons.Sys;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * @Description:
 * @Date: 2020/6/24  14:33
 * @Author: dongdong
 */

public class GetExcelData {

    @Test
    public  void  getData() throws InvalidFormatException, Excel4JException, IOException {
     List<CarDto> data= ExcelUtils.getInstance().readExcel2Objects("D:\\test.xlsx",CarDto.class);
     System.out.println(data);
    }
}
