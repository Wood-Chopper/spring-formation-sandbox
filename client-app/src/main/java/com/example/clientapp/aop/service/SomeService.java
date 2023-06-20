package com.example.clientapp.aop.service;

import com.example.clientapp.aop.annotation.Timed;
import org.springframework.stereotype.Service;

@Service
public class SomeService {

    @Timed
    public int addition(int a, int b) {
        return a + b;
    }
}
