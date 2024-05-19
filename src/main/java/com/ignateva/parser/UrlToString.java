package com.ignateva.parser;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class UrlToString {
    static public String GetSite (String url)
    {
        try
        {
            URL url1 = new URL(url);
            URLConnection test = url1.openConnection();
            InputStream stream= test.getInputStream();
            InputStreamReader Inputreader =  new InputStreamReader(stream);
            BufferedReader reader = new BufferedReader(Inputreader);
            String site="";
            while (reader.ready())
            {
                site +=reader.readLine()+"\r";
            }
            return site;
        }
        catch (Exception e) {
            return e.getMessage();
        }
    }
}
