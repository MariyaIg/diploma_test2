package com.ignateva.service;

import jakarta.servlet.http.HttpSession;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class CreateExcelFile {


    public String createFile(List list) {
        String n = String.valueOf(Math.random());
        String filename = "C:\\Users\\Мария\\apache-tomcat-10.1.19\\apache-tomcat-10.1.19\\webapps\\diploma_test2_war\\data1.xls";
        try {

            HSSFWorkbook hwb = new HSSFWorkbook();
            HSSFSheet sheet = hwb.createSheet("new sheet");
/*
        HSSFRow rowhead=   sheet.createRow((short)0);
        HSSFRow row=   sheet.createRow((short)0);
            rowhead.createCell((short) 1).setCellValue("Компания");
        HSSFRow row1=   sheet.createRow((short)1);
            row.createCell((short) 1).setCellValue("ИНН");
        HSSFRow row2=   sheet.createRow((short)2);
            row.createCell((short) 1).setCellValue("Рейтинг");
        HSSFRow row3=   sheet.createRow((short)3);
            row.createCell((short) 1).setCellValue("Отчетная дата");
        HSSFRow row4=   sheet.createRow((short)4);
            row.createCell((short) 1).setCellValue("Пользователь");
*/


            for (int i = 0; i < list.size(); i++) {

                HSSFRow row5 = sheet.createRow((short) i);
                row5.createCell((short) 3).setCellValue((String) list.get(i));


            }
            FileOutputStream fileOut = new FileOutputStream(filename);
            hwb.write(fileOut);
            fileOut.close();
            System.out.println("Your excel file has been generated!");

        } catch (Exception ex) {
            System.out.println(ex);

        }
        return filename;
    }


}

