package com.shadowvzs;

public class BasicTypes {
    public static void main(String[] args) {
        byte age = 20;
        int id = 456_456_452;
        long counter = 3_333_3333_333L;
        float price = 15.26F;
        // D suffix optional
        double bigPrice = 1_230_123.261D;
        char letter = 'A';
        String userName = "pasta";
        // userName.equals("pasta");
        boolean agree = true;

        // final = constant
        final float pi = 3.14F;

        int result1 = 10 / 3; // is 3 because it is int and not float
        result1 += 2; // 5

        // explicit casting
        double x = 1.1;
        int y = (int)x + 2; // example it use Int.parseInt(x)
        String strNr = "1.1";
        float convertedStringToNumber = Float.parseFloat(strNr); // or (float)x

        System.out.println(id);
        System.out.println(age);
        System.out.println(counter);
        System.out.println(price);
        System.out.println(bigPrice);
        System.out.println(letter);
        System.out.println(userName);
        System.out.println(agree);
        System.out.println(pi);
        System.out.println(result1);
        System.out.println(y);
        System.out.println(convertedStringToNumber);
    }
}