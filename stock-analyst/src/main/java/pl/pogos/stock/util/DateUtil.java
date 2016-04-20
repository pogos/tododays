package pl.pogos.stock.util;

import java.time.*;
import java.util.Date;

public final class DateUtil {

    public static final int HOUR_WITHOUT_ZERE_LENGTH = 4;

    private DateUtil() {
    }

    public static Date todayAt(String hour) {
        LocalTime time = LocalTime.parse(isHourDoesntStartFormZero(hour) ? "0" + hour : hour);
        LocalDateTime dateTime = LocalDateTime.of(LocalDate.now(), time);
        return Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    private static boolean isHourDoesntStartFormZero(String hour) {
        return hour.length() == HOUR_WITHOUT_ZERE_LENGTH;
    }
}
