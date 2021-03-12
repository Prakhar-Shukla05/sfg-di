package com.prakhar.practise.di_examples.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

public class I18nHindiGreetingService implements GreetingService{
    @Override
    public String sayGreeting() {
        return "Namaskar Doston - HI";
    }
}
