package com.ignateva.parser;

import com.ignateva.entity.Industry;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class IndustryFromSite {
  public static HashSet<Industry> getIndustryList(String site){
        HashSet<Industry> result = new HashSet<>();
      int index = site.indexOf("<td>");

      while (index!=-1)
      {
          site= site.substring(index+4);

          float code = Float.parseFloat(site.substring(0, site.indexOf('<')));

          index = site.indexOf("<td>");
          site= site.substring(index+4);
          String title = site.substring(0, site.indexOf('<'));

          result.add(new Industry(title,code));
          index = -1;
      }

      return result;
    }
}
