package com.shadowvzs;

import java.util.Scanner;

public class Input {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your age: ");
        byte age = scanner.nextByte();
        System.out.println("You are " + age);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine().trim();
        System.out.println("Your name: " + name);

//        boolean itIsOk = false;
//        Scanner scanner = new Scanner(System.in);
//        int result;
//
//        while (!itIsOk) {
//            System.out.print("Enter a number between 2-5: ");
//            result = scanner.nextInt();
//            if (result >= 2 && result <= 5) {
//                itIsOk = true;
//            }
//        }
    }
}
