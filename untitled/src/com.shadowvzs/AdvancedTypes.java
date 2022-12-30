package com.shadowvzs;

import java.awt.*;
import java.util.Arrays;
import java.util.Date;

public class AdvancedTypes {
    public static void main(String[] args) {
        // primitive: numbers, characters, booleans
        // references: date, mail message, objects
        Date now = new Date();
        Point point1 = new Point(1, 1);
        String message = "\"some\"thing\n" + "\telse";

        // simple arrays
        int[] notes1 = new int [6];
        notes1[1] = 4;

        int[] notes2 = { 2, 5, 4 };

        // 2 dimension array (each dimension required [])
        int[][] notes3 = new int [3][2];
        notes3[0][0] = 4;

        int[][] notes4 = { { 2, 5 }, { 1 , 4 } };

        System.out.println(now);
        System.out.println(point1);
        System.out.println(message);
        System.out.println(message.endsWith("else"));
        System.out.println(message.length());
        System.out.println(Arrays.toString(notes1)); // 0, 4, 0, 0, 0, 0
        Arrays.sort(notes2);
        System.out.println(Arrays.toString(notes2)); // 2, 4, 5

        System.out.println(Arrays.deepToString(notes3)); // [[4, 0], [0, 0], [0, 0]]
        System.out.println(Arrays.deepToString(notes4)); // [[2, 5], [1, 4]]

        Car[] cars = { new Car("Dacia"), new Car("Volcano") };
        System.out.println(cars[0].name.toString());
        System.out.println(cars[0].count);

        // class constructor doesn't have a return type
    }
}