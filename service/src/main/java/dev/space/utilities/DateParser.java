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
    private static final SimpleDateFormat formatter;

    private DateParser() {
    }

    static {
        formatter = new SimpleDateFormat(DATE_FORMAT);
        formatter.setTimeZone(TimeZone.getTimeZone("GMT+2"));
    }

    public static Date FormatDate(String date) throws ParseException {

        return formatter.parse(date);

    }
}
