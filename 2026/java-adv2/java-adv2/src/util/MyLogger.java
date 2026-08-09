package util;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author : gayul.kim
 * @date : 2026. 8. 6.
 * @fileName : MyLogger
 */
public class MyLogger {
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");

    public static void log(Object obj) {
        String time = LocalTime.now().format(formatter);
        System.out.printf("%s [%9s] %s\n", time, Thread.currentThread().getName(), obj);
    }
}
