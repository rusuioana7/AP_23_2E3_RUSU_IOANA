package comm;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import java.text.DateFormatSymbols;
import java.util.Currency;
import java.util.Locale;

public class Info {
    public void display(Locale locale) {
        System.out.println("Country: " + locale.getDisplayCountry(locale));
        System.out.println("Language: " + locale.getDisplayLanguage(locale));

        try {
            Currency currency = Currency.getInstance(locale);
            System.out.println("Currency: " + currency.getCurrencyCode());
        } catch (IllegalArgumentException e) {
            System.out.println("Currency: Not available for this locale");
        }

        System.out.println("Week Days: " + String.join(", ", DateFormatSymbols.getInstance(locale).getWeekdays()));
        System.out.println("Months: " + String.join(", ", DateFormatSymbols.getInstance(locale).getMonths()));
        System.out.println("Today: " + DateFormatSymbols.getInstance(locale).getShortMonths()[4] + " 8, 2016");
    }
}