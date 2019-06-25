package de.piinguiin.lootbox.utils;

import java.text.NumberFormat;
import java.util.Locale;

public class Utils {

    public static String formatInt(int toFormat) {
        NumberFormat nf_eu = NumberFormat.getInstance(Locale.GERMANY);
        String number_eu = nf_eu.format(toFormat);
        return number_eu;
    }

}
