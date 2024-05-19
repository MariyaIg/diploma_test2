package com.ignateva.parser;

import com.ignateva.entity.Industry;

import java.io.File;
import java.util.HashSet;

public class IndustryFromFile {
/*
    public static HashSet<Industry> getIndustryList(File file) {
        FileManager fileManager = new FileManager();
        String text = String.valueOf(fileManager.ReadFile(file));
        HashSet<Industry> result = new HashSet<>();
        int index1 = text.indexOf("code");
        int index2 = text.indexOf("name");

        String code = text.substring(index1 + 9, text.indexOf('"'));
        text = text.substring(index2);
        String title = text.substring(index2 + 9, text.indexOf('"'));
        result.add(new Industry(title, code));
        /*
        while (index1 != -1||index2!=-1) {

            String code = text.substring(index1 + 9, text.indexOf('"'));
            text = text.substring(index2);
            String title = text.substring(index2 + 9, text.indexOf('"'));
            result.add(new Industry(title, code));
            index1 = -1;
            index2 =-1;

        }


        return result;
    }

}
/* for (int i = 0; i < text.length(); i++) {
                if (text.substring(index1 + 9, index1 + 10).equals("Р")) {
                    continue;
                }*/

}