package app;

import comm.DisplayLocales;
import comm.Info;
import comm.SetLocale;

import java.util.Locale;
import java.util.Scanner;

public class LocaleExplore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DisplayLocales displayLocales = new DisplayLocales();
        SetLocale setLocale = new SetLocale();
        Info info = new Info();
        String command;

        System.out.println("Locale Explorer - Type a command (display locales, set locale [language], info)");
        while (true) {
            command = scanner.nextLine();

            if (command.equalsIgnoreCase("display locales")) {
                displayLocales.display();
            } else if (command.toLowerCase().startsWith("set locale")) {
                String[] parts = command.split(" ");
                if (parts.length == 3) {
                    String languageTag = parts[2];
                    setLocale.set(languageTag);
                } else {
                    System.out.println("Invalid set locale command");
                }
            } else if (command.equalsIgnoreCase("info")) {
                Locale currentLocale = Locale.getDefault();
                info.display(currentLocale);
            } else {
                System.out.println("Invalid command.");
            }
        }
    }
}
