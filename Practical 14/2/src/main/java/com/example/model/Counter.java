package com.example.model;

public class Counter {
    private int count;

    public int getCount() {
        return count;
    }

    public void increment() {
        count++;
    }

    public void setCount(int count) {
        if (count < 0) {
            throw new IllegalArgumentException("Count cannot be negative");
        }
        this.count = count;
    }
}
