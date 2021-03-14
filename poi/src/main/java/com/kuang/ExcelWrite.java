package com.kuang;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.joda.time.DateTime;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author thirteenmj
 * Date: 2021/3/14 21:58
 */
public class ExcelWrite {

    public static String PATH = "/excel";

    @Test
    public void testWrite03() throws Exception {
        //1、创建一个工作薄
        Workbook workbook = new HSSFWorkbook();
        //2、创建一个工作表
        Sheet sheet = workbook.createSheet("狂神观众统计表");
        //3、创建一个行
        Row row1 = sheet.createRow(0);
        //4、创建一个单元格
        //(1,1)
        Cell cell11 = row1.createCell(0);
        cell11.setCellValue("今日的新增观众");
        //(1,2)
        Cell cell12 = row1.createCell(1);
        cell12.setCellValue(666);

        //第二行
        //(2,1)
        Row row2 = sheet.createRow(1);
        Cell cell21 = row2.createCell(0);
        cell21.setCellValue("统计时间");
        //(2,2)
        Cell cell22 = row2.createCell(1);
        String time = new DateTime().toString("yyyy-MM-dd HH:ss:mm");
        cell22.setCellValue(time);

        //生成一张表（IO流）  03版本就是使用xls结尾
        FileOutputStream out = new FileOutputStream(PATH + "狂神观众统计表03.xls");

        workbook.write(out);
        //关闭流
        out.close();

        System.out.println("狂神观众统计表03 生成完毕!");
    }
}