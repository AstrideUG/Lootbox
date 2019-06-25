package de.piinguiin.lootbox.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimeUtil {
    public static long parseTime(String timeformat) {
        Pattern pattern = Pattern.compile("(?:([0-9]+)\\s*y[a-z]*[,\\s]*)?(?:([0-9]+)\\s*mo[a-z]*[,\\s]*)?(?:([0-9]+)\\s*w[a-z]*[,\\s]*)?(?:([0-9]+)\\s*d[a-z]*[,\\s]*)?(?:([0-9]+)\\s*h[a-z]*[,\\s]*)?(?:([0-9]+)\\s*m[a-z]*[,\\s]*)?(?:([0-9]+)\\s*(?:s[a-z]*)?)?",

                2);
        Matcher matcher = pattern.matcher(timeformat);

        long years = 0L;
        long month = 0L;
        long weeks = 0L;
        long days = 0L;
        long hours = 0L;
        long minutes = 0L;
        long seconds = 0L;
        boolean found = false;
        while (matcher.find()) {
            if ((matcher.group() != null) && (!matcher.group().isEmpty())) {
                for (int i = 0; i < matcher.groupCount(); i++) {
                    if ((matcher.group(i) != null) && (!matcher.group(i).isEmpty())) {
                        found = true;
                        break;
                    }
                }
                if (found) {
                    if ((matcher.group(1) != null) && (!matcher.group(1).isEmpty())) {
                        years = Long.parseLong(matcher.group(1));
                    }
                    if ((matcher.group(2) != null) && (!matcher.group(2).isEmpty())) {
                        month = Long.parseLong(matcher.group(2));
                    }
                    if ((matcher.group(3) != null) && (!matcher.group(3).isEmpty())) {
                        weeks = Long.parseLong(matcher.group(3));
                    }
                    if ((matcher.group(4) != null) && (!matcher.group(4).isEmpty())) {
                        days = Long.parseLong(matcher.group(4));
                    }
                    if ((matcher.group(5) != null) && (!matcher.group(5).isEmpty())) {
                        hours = Long.parseLong(matcher.group(5));
                    }
                    if ((matcher.group(6) != null) && (!matcher.group(6).isEmpty())) {
                        minutes = Long.parseLong(matcher.group(6));
                    }
                    if ((matcher.group(7) != null) && (!matcher.group(7).isEmpty())) {
                        seconds = Long.parseLong(matcher.group(7));
                    }
                }
            }
        }
        if (!found) {
            return -1L;
        }
        long millis = 0L;
        if (years > 0L) {
            millis += years * 224985600000L;
        }
        if (month > 0L) {
            millis += month * 18748800000L;
        }
        if (weeks > 0L) {
            millis += weeks * 604800000L;
        }
        if (days > 0L) {
            millis += days * 86400000L;
        }
        if (hours > 0L) {
            millis += hours * 3600000L;
        }
        if (minutes > 0L) {
            millis += minutes * 60000L;
        }
        if (seconds > 0L) {
            millis += seconds * 1000L;
        }
        return millis;
    }

    public static String timeToString(long time, boolean shorten) {
        String msg = "";
        long seconds = time / 1000L;
        if (seconds >= 86400L) {
            long days = seconds / 86400L;
            msg = msg + days + (days == 1L ? " Tag, " : shorten ? "d " : " Tage, ");
            seconds %= 86400L;
        }
        if (seconds >= 3600L) {
            long hours = seconds / 3600L;
            msg = msg + hours + (hours == 1L ? " Stunde, " : shorten ? "h " : " Stunden, ");
            seconds %= 3600L;
        }
        if (seconds >= 60L) {
            long minutes = seconds / 60L;
            msg = msg + minutes + (minutes == 1L ? " Minute, " : shorten ? "m " : " Minuten, ");
            seconds %= 60L;
        }
        if (seconds > 0L) {
            msg = msg + seconds + (seconds == 1L ? " Sekunde, " : shorten ? "s " : " Sekunden, ");
        }
        if (!msg.isEmpty()) {
            msg = msg.substring(0, msg.length() - (shorten ? 1 : 2));
        } else {
            msg = shorten ? "0s" : "0 Sekunden";
        }
        return msg;
    }

    public static String timeToStringApproximately(long time, boolean shorten) {
        String msg = "";
        long seconds = time / 1000L;
        if (seconds >= 86400L) {
            long days = seconds / 86400L;
            msg = msg + days + (days == 1L ? " Tag" : shorten ? "d" : " Tage");
            return msg;
        }
        if (seconds >= 3600L) {
            long hours = seconds / 3600L;
            msg = msg + hours + (hours == 1L ? " Stunde" : shorten ? "h" : " Stunden");
            return msg;
        }
        if (seconds >= 60L) {
            long minutes = seconds / 60L;
            msg = msg + minutes + (minutes == 1L ? " Minute" : shorten ? "m" : " Minuten");
            return msg;
        }
        if (seconds > 0L) {
            msg = msg + seconds + (seconds == 1L ? " Sekunde" : shorten ? "s" : " Sekunden");
            return msg;
        }
        if (!msg.isEmpty()) {
            msg = msg.substring(0, msg.length() - (shorten ? 1 : 2));
        } else {
            msg = shorten ? "0s" : "0 Sekunden";
        }
        return msg;
    }
}
