package com.shadowvzs;

import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {
    public static void main(String[] args) {
        // P - loan amount: 100 000$
        // r - is monthly interest rate: 5%
        // n is number of months for paying the loan: 12
        // formula M = P * ( (r * (1+r)^n)  /  ((1 + r) ^ n - 1))
        Scanner scanner = new Scanner(System.in);

        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        System.out.print("Enter principal (loan): ");
        int principal = scanner.nextInt();
        System.out.print("Annual interest rate (%): ");
        float annuallyInterest = scanner.nextFloat();
        float monthlyInterest = annuallyInterest / PERCENT / MONTHS_IN_YEAR;
        System.out.print("Enter loan term (month): ");
        int numberOfPayments = scanner.nextInt() * MONTHS_IN_YEAR;

        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
        System.out.println(principal);
        System.out.println(monthlyInterest);
        System.out.println(numberOfPayments);

        String morgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);

        System.out.println(morgageFormatted);
    }
}
