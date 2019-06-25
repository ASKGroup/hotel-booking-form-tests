package com.equalExports.technical.assement.utils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DateHelper {

    private String getDate(int plusMonths, int plusDays) {
        LocalDate localDateTime = new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return localDateTime.plusMonths(plusMonths).plusDays(plusDays).toString();
    }

    public String getTodaysDate(){
      return  getDate(0,0);
    }

    public String getFutureDate(int days){
        return getDate(0,days);
    }
}
