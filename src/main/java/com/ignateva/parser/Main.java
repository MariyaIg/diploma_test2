package com.ignateva.parser;

import com.ignateva.entity.Industry;
import com.ignateva.service.FormService;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        ReadExlFile3 readExlFile =new ReadExlFile3();
      //  Map<Integer, Industry> data = readExlFile.parseFile(filePart);
        FormService formService=new FormService();
        String mess = formService.createIndustriesFromFile();

       // System.out.println(data.values().toString());

       // Scanner scan = new Scanner(System.in);
       // File file = new File("C:\\Users\\Мария\\IdeaProjects\\diploma_test2\\src\\main\\resources\\codes.txt");
       // String site = UrlToString.GetSite(
        //       "https://gist.githubusercontent.com/dmitry-naumenko/5a8afef9d94e9bcf9d91052dd65089ab/raw/c19ebdf3594e60db183cc2a9be9a7996a63dbf66/%25D0%25BE%25D0%25BA%25D0%25B2%25D1%258D%25D0%25B4.json");
       // HashSet<Industry> industries = IndustryFromSite.getIndustryList(site);

       // System.out.print(IndustryFromFile.getIndustryList(file));

    }

}
