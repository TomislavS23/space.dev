package dev.space.utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 *
 * @author tomislav
 */
public class DateParser {

    private static final String DATE_FORMAT = "EEE, dd MMM yyyy HH:mm:ss Z";
    private static final String TARGET_FORMAT = "yyyy-MM-dd";
    private static SimpleDateFormat formatter;

    private DateParser() {
    }

    public static Date FormatDate(String date) throws ParseException {
        formatter = new SimpleDateFormat(DATE_FORMAT);
        formatter.setTimeZone(TimeZone.getTimeZone("GMT+2"));
        
        return formatter.parse(date);
    }

    public static String FormatToString(Date date) {
        formatter = new SimpleDateFormat(TARGET_FORMAT);
        formatter.setTimeZone(TimeZone.getTimeZone("GMT+2")); 
        
        return formatter.format(date);
    }
}
