package utils;

import org.apache.logging.log4j.LogManager;

public class Logger {
    private static org.apache.logging.log4j.Logger log = LogManager.getLogger();

    public static void infoConsole(String s) {
        log.info(s);
    }

    public static void warningConsole(String s) {
        log.warn(s);
    }

    public static void errorConsole(String s) {
        log.error(s);
    }


}
