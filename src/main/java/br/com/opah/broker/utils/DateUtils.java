package br.com.opah.broker.utils;

import java.time.Duration;
import java.time.ZoneId;
import java.util.Date;

public class DateUtils {

    public static long getTotalDays(Date startDate, Date endDate) {
        return Duration.between(startDate.toInstant()
            .atZone(ZoneId.systemDefault()), endDate.toInstant().atZone(ZoneId.systemDefault())).toDays();
    }
}