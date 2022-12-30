package com.shadowvzs;

import java.io.File;
import java.text.NumberFormat;

public class InBuiltMethods {
    public static void main(String[] args) {
        // Math have min/max/floor/round/ceil/pow as it is in JavaScript
        double rnd = Math.random(); // or 0-100 (int) (Math.random() * 100);

        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String result1 = currency.format(1234567.891);

        NumberFormat percent = NumberFormat.getPercentInstance();
        String result2 = percent.format(0.1);

        System.out.println(rnd);
        System.out.println(result1); // $ 1,234,567,89
        System.out.println(result2); // 10%

        // note: cannot declare variable in if blocks

        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }

        int x = 0;
        while (x < 5) {
            System.out.println(x);
            x++;
        }
    }
}
