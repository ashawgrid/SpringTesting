package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CounterService {

    private int count;

    public CounterService(@Value("${counter.initial-value:0}") int initialValue) {
        this.count = initialValue;
    }

    public void increment() {
        count++;
    }

    public void reset() {
        count = 0;
    }

    public int getCount() {
        return count;
    }
}
