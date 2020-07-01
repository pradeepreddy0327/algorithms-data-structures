package hacker.rank;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class CurrencyFormatter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();

        System.out.println("US: " + toCurrency(Locale.US, payment));
        System.out.println(
                "India: " + toCurrency(new Locale("hi", "IN"), payment));
        System.out.println("China: " + toCurrency(Locale.CHINA, payment));
        System.out.println("France: " + toCurrency(Locale.FRANCE, payment));
        Map<String, Integer> anagMap = new HashMap<>();
        Integer f = anagMap.getOrDefault("abc", 0);

    }

    private static String toCurrency(Locale locale, double payment) {
        return NumberFormat.getCurrencyInstance(locale).format(payment);
    }

}
