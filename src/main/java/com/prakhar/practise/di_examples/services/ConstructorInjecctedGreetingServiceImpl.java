package com.prakhar.practise.di_examples.services;

import org.springframework.stereotype.Service;


public class ConstructorInjecctedGreetingServiceImpl implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hello World-- Constructor";
    }
}
