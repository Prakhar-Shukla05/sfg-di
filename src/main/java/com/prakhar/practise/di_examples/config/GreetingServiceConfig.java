package com.prakhar.practise.di_examples.config;

import com.prakhar.practise.di_examples.services.ConstructorInjecctedGreetingServiceImpl;
import com.prakhar.practise.di_examples.services.PropertyInjectedGreetingService;
import com.prakhar.practise.di_examples.services.SetterInjectedGreetingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GreetingServiceConfig {

    @Bean
    ConstructorInjecctedGreetingServiceImpl constructorInjecctedGreetingServiceImpl(){
        return new ConstructorInjecctedGreetingServiceImpl();
    }

    @Bean
    PropertyInjectedGreetingService propertyInjectedGreetingService(){
        return new PropertyInjectedGreetingService();
    }

    @Bean
    SetterInjectedGreetingService setterInjectedGreetingService(){
        return new SetterInjectedGreetingService();
    }
}
