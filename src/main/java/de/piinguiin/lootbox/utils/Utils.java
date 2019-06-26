package de.piinguiin.lootbox.utils;

import java.text.NumberFormat;
import java.util.Locale;

public class Utils {

    //todo change it to darkness
    public static String formatInt(final int toFormat) {
        final NumberFormat nf_eu = NumberFormat.getInstance(Locale.GERMANY);
        final String number_eu = nf_eu.format(toFormat);
        return number_eu;
    }

}
