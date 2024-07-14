package com.ignateva.service;

import com.ignateva.dao.IndustryDao;
import com.ignateva.entity.Industry;
import com.ignateva.parser.ReadExlFile;
import com.ignateva.parser.ReadExlFile2;
import jakarta.servlet.http.Part;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import static com.ignateva.parser.ReadExlFile3.parseFile;

public class LoadService {

    public String createIndustriesFromFile() {
        String mess = "";
        IndustryDao industryDao = new IndustryDao();
        ReadExlFile2 readExlFile2 = new ReadExlFile2();
        Map<Integer, Industry> data = null;
        try {
            data = readExlFile2.parse();
            for (int i = 0; i < data.size(); i++) {
                industryDao.insertIndustry(data.get(i));

            }

            return mess;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public String createIndustriesFromFileExl(Part filePart) {
        String mess = "success";
        IndustryDao industryDao = new IndustryDao();
        // ReadExlFile3 readExlFile3 = new ReadExlFile3();
        Map<Integer, Industry> data = null;
        try {
            data = parseFile(filePart);
            for (int i = 0; i < data.size(); i++) {
                industryDao.insertIndustry(data.get(i));

            }

            return mess;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public String createIndustriesFromFile(String filepath) {
        String mess = "";
        IndustryDao industryDao = new IndustryDao();
        ReadExlFile readExlFile = new ReadExlFile();
        Map<Integer, Industry> data = null;
        try {
            data = readExlFile.parse(filepath);
            for (int i = 0; i < data.size(); i++) {
                industryDao.insertIndustry(data.get(i));
            }
            return mess;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public String updateIndustriesFromFile(String filePath) {
        String mess = "";
        IndustryDao industryDao = new IndustryDao();
        ReadExlFile readExlFile = new ReadExlFile();
        Map<Integer, Industry> data = null;
        try {
            data = readExlFile.parse(filePath);
            for (int i = 0; i < data.size(); i++) {
                industryDao.updateIndustryRisk(data.get(i));
            }
            return mess="success";
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
