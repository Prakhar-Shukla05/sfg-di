package com.prakhar.practise.di_examples.controllers;

import org.springframework.stereotype.Controller;

@Controller
public class MyController {

    public String sayHello(){
        System.out.println("Hello World!!!");

        return "Hey there, This is Prakhar";
    }
}
