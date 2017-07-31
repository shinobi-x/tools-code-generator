package cn.uc.codegenerator.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.apache.commons.lang.StringUtils;

public class DateUtil {
    public static String DateToString(java.util.Date date, String format) {
        if (date == null) {
            date = new java.util.Date();
        }
        if (StringUtils.isEmpty(format)) {
            format = "yyyy-MM-dd HH:mm:ss";
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);

        return simpleDateFormat.format(date);
    }

    public static java.util.Date StringToDate(String dateStr, String format) {
        if (StringUtils.isEmpty(format)) {
            format = "yyyy-MM-dd HH:mm:ss";
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        java.util.Date date = null;
        try {
            date = simpleDateFormat.parse(dateStr);
            if (date.getTime() > System.currentTimeMillis()) {
                date = new java.util.Date();
            }
        } catch (ParseException e1) {
            return null;
        }
        return date;
    }

    public static String getCurrentDate(String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);

        return sdf.format(new java.util.Date());
    }

    public static java.util.Date getNowUtilDate() {
        return new java.util.Date();
    }

    public static java.sql.Date getNowSqlDate() {
        return new java.sql.Date(System.currentTimeMillis());
    }

    public static Timestamp getNowTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }
}
