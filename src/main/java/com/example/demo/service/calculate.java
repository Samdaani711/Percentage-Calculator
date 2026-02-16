package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class calculate {

    public double calculatePercentage(int m1, int m2, int m3) {
        int total = m1 + m2 + m3;
        return (total / 300.0) * 100;
    }
}

