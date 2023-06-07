package comm;

import java.util.Locale;

public class SetLocale {
    public void set(String languageTag) {
        Locale locale = Locale.forLanguageTag(languageTag);
        Locale.setDefault(locale);
        System.out.println("Current locale set to: " + locale.getDisplayName());
    }
}

