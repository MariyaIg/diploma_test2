package com.ignateva.parser;

import com.ignateva.entity.Industry;
import jakarta.servlet.http.Part;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadExlFile3 {

    public static Map<Integer, Industry> parseFile(Part filepart) throws IOException {
        FileInputStream fileInputStream = (FileInputStream)filepart.getInputStream();
        Map<Integer, Industry> data;
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
            Sheet sheet = workbook.getSheetAt(0);

            data = new HashMap<>();
            int i = 0;
            for (Row row : sheet) {
                data.put(i, new Industry());
                for (Cell cell : row) {
                    switch (cell.getColumnIndex()) {
                        case 0:
                            data.get(i)
                                    .setCode(cell.getRichStringCellValue()
                                            .getString());
                            break;
                        case 1:
                            data.get(i)
                                    .setTitle(cell.getRichStringCellValue()
                                            .getString());
                            break;
                        case 2:
                            data.get(i)
                                    .setRisk(Integer.parseInt((int) cell.getNumericCellValue() + ""));
                            break;

                    }

                }
                i++;

            }
            workbook.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return data;
    }

}
