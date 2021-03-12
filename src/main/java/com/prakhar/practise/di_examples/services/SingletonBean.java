package com.prakhar.practise.di_examples.services;

import org.springframework.stereotype.Component;

@Component
public class SingletonBean {

    public SingletonBean() {
        System.out.println("Present in singleton bean!!!");
    }

    public String getScope()
    {
        return "I'm a Singleton";
    }
}
