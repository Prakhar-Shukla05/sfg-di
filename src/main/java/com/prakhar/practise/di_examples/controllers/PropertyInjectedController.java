package com.prakhar.practise.di_examples.controllers;

import com.prakhar.practise.di_examples.services.GreetingService;

public class PropertyInjectedController {

    public GreetingService greetingService;

    public String getGreeting(){
        return greetingService.sayGreeting();
    }
}
