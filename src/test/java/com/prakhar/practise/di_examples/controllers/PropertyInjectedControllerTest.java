package com.prakhar.practise.di_examples.controllers;

import com.prakhar.practise.di_examples.services.ConstructorInjecctedGreetingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PropertyInjectedControllerTest {

    PropertyInjectedController controller;

    @BeforeEach
    void setUp() {
        controller= new PropertyInjectedController();

        controller.greetingService= new ConstructorInjecctedGreetingServiceImpl();
    }

    @Test
    void getGreeting() {
        System.out.println(controller.getGreeting());
    }
}