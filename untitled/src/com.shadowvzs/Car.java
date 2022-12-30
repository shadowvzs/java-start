package com.shadowvzs;

public class Car extends Vehicle {
    public String name;

    static int count = 0;

    public Car(String name) {
        super(name);
        this.name = name;
        count++;
    }
}
