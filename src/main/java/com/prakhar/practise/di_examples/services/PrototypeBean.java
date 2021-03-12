package com.prakhar.practise.di_examples.services;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
public class PrototypeBean {

    public PrototypeBean() {
        System.out.println("Present in Prototype Bean !!!!!");
    }

    public String getScope()
    {
        return "I'm a Prototype";
    }
}
