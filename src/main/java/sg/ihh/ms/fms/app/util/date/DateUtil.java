package sg.ihh.ms.fms.app.util.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    private static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final DateTimeFormatter DATE_FORMATTER_FE = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private static final DateTimeFormatter DATE_FORMATTER_BE = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter TIME_FORMATTER_FE = DateTimeFormatter.ofPattern("HH:mm:ss");

    private DateUtil() {}

    public static String formatLocalDateTime(LocalDateTime localDateTime) {
        return DATETIME_FORMATTER.format(localDateTime);
    }

    public static String formatLocalDate(LocalDate localDate) {
        return DATE_FORMATTER_BE.format(localDate);
    }

    public static LocalDateTime parseDateTime(String str) {
        return LocalDateTime.parse(str, DATETIME_FORMATTER);
    }

    // convert FE date format to BE date format
    public static LocalDate parseDateFEtoBE(String str) {
        LocalDate feDate = LocalDate.parse(str, DATE_FORMATTER_FE);
        String    dbDate = DATE_FORMATTER_BE.format(feDate);
        return LocalDate.parse(dbDate, DATE_FORMATTER_BE);
    }

    public static String getTodayDate() {
        return DATE_FORMATTER_BE.format(LocalDate.now());
    }

    public static String getCurrenTime() {
        return TIME_FORMATTER_FE.format(LocalDateTime.now());
    }

}
