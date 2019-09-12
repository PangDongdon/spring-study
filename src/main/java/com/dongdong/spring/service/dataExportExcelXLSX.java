package com.dongdong.spring.service;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;

/**
 * 导出数据类
 * @Description:
 * @Auther: dongdong
 * @Date: 2019/9/12  14:37
 */
public class dataExportExcelXLSX {

    /**
     * 生成excel
     *
     * */
    public void  zxExportData(){
        XSSFWorkbook wb=new XSSFWorkbook();
        Sheet sheet= wb.createSheet("dd");
        for(int i=0;i<9;i++){
            sheet.setColumnWidth(i,4300);
        }

        //设置单元格格式
        CellStyle cellStyle=wb.createCellStyle();
        cellStyle.setBorderTop(BorderStyle.THIN);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        cellStyle.setBorderLeft(BorderStyle.THIN);
        cellStyle.setBorderRight(BorderStyle.THIN);
        cellStyle.setTopBorderColor(HSSFColor.BLACK.index);
        cellStyle.setBottomBorderColor(HSSFColor.BLACK.index);
        cellStyle.setLeftBorderColor(HSSFColor.BLACK.index);
        cellStyle.setRightBorderColor(HSSFColor.BLACK.index);
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); // 上下居中

        //标题样式格式
        XSSFFont titleFont=wb.createFont();
        titleFont.setFontHeight(24);
        titleFont.setBold(true);
        CellStyle titleCellStyle = wb.createCellStyle();
        titleCellStyle.setBorderTop(BorderStyle.THIN);
        titleCellStyle.setBorderBottom(BorderStyle.THIN);
        titleCellStyle.setBorderLeft(BorderStyle.THIN);
        titleCellStyle.setBorderRight(BorderStyle.THIN);
        titleCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 水平居中
        titleCellStyle.setTopBorderColor(HSSFColor.BLACK.index);
        titleCellStyle.setBottomBorderColor(HSSFColor.BLACK.index);
        titleCellStyle.setLeftBorderColor(HSSFColor.BLACK.index);
        titleCellStyle.setRightBorderColor(HSSFColor.BLACK.index);
        titleCellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); // 上下居中
        titleCellStyle.setFont(titleFont);

        //主标题在这里插入主标题
        Row titleRow;
        Cell titleCell;
        sheet.addMergedRegion(new CellRangeAddress((short)0,(short)2,(short)0,(short)8));
        for(int i=0;i<=2;i++){
            titleRow=sheet.createRow(i);
            for(int j=0;j<9;j++){
                titleCell=titleRow.createCell(j);
                titleCell.setCellType(CellType.STRING);
                titleCell.setCellStyle(titleCellStyle);
                titleCell.setCellValue("to be number 1");
            }
        }

        //列标题在这里插入列标题
        Row rowLabel;
        Cell cellLabel;
        for (int i = 3; i < 4; i++) {
            rowLabel = sheet.createRow(i);
            for (int j = 0; j < 9; j++) {
                cellLabel = rowLabel.createCell(j);
                cellLabel.setCellType(CellType.STRING);
                cellLabel.setCellStyle(cellStyle);
                cellLabel.setCellValue("测试标题列【" + (j + 1) + "】");
            }
        }


        //插入列数据
        Row rowCheck;
        Cell cellCheck;
        for (int i = 3; i < 5; i++) {
            rowCheck = sheet.createRow((i + 1));
            for (int j = 0; j < 8; j++) {
                cellCheck = rowCheck.createCell(j);
                cellCheck.setCellType(CellType.STRING);
                cellCheck.setCellStyle(cellStyle);
                cellCheck.setCellValue("测试 - 0" + (i - 2));
            }
        }

        //页脚
        setExcelFooterName("开发",0,wb);

        //导出
        exportOutPutExcel("C:\\Users\\pdd\\Desktop\\代理商订单导出\\"+(System.currentTimeMillis()/1000)+"data.xlsx",wb);


    }



    /**
     * 设置excel页脚
     *
     * */
    public void setExcelFooterName(String customExcelFooterName,int setExcelFooternumber,XSSFWorkbook wb){
        wb.setSheetName(setExcelFooternumber,customExcelFooterName);
    }


    /**
     * 输出流 导出到Excel
     * */
   public  void exportOutPutExcel(String exportPositionPath,XSSFWorkbook wb){
       try{
           File file =new File(exportPositionPath);
          // if(file.exists()) {
          //     file.delete();
               file.createNewFile();
        //   }
           FileOutputStream fileOutputStream=new FileOutputStream(file);
           wb.write(fileOutputStream);
       }catch(Exception e){
           System.out.println(e.getMessage());
       }

   }

  public static  void main(String[] args){
       new dataExportExcelXLSX().zxExportData();
  }


}
