package com.prakhar.practise.di_examples.config;

import com.prakhar.practise.di_examples.repositories.EnglishGreetingRepository;
import com.prakhar.practise.di_examples.repositories.EnglishGreetingRepositoryImpl;
import com.prakhar.practise.di_examples.services.*;
import com.prakhar.practise.pets.CatPetService;
import com.prakhar.practise.pets.PetService;
import com.prakhar.practise.pets.PetServiceFactory;
import org.springframework.context.annotation.*;

@ImportResource("classpath:di-examples-config.xml")
@Configuration
public class GreetingServiceConfig {

    @Primary
    @Bean
    PrimaryGreetingService primaryGreetingService(){
        return new PrimaryGreetingService();
    }

    @Bean
    PetServiceFactory petServiceFactory(){
        return new PetServiceFactory();
    }

    @Bean
    @Profile("cat")
    PetService catPetService(){
        return petServiceFactory().getPetService("cat");
    }

    @Bean
    @Profile({"dog","default"})
    PetService dogPetService(){
        return petServiceFactory().getPetService("dog");
    }

    @Profile("EN")
    @Bean
    I18nEnglishGreetingService i18nService(EnglishGreetingRepository englishGreetingRepository){
        return new I18nEnglishGreetingService(englishGreetingRepository);
    }

    @Bean
    EnglishGreetingRepository englishGreetingRepository(){
        return new EnglishGreetingRepositoryImpl();
    }

    @Profile({"HI", "default"})
    @Bean("i18nService")
    I18nHindiGreetingService i18nHindiGreetingService(){
        return new I18nHindiGreetingService();
    }

   // @Bean
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
