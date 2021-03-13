package com.prakhar.practise.di_examples.config;

import com.prakhar.practise.di_examples.datasource.FakeDataSource;
import com.prakhar.practise.di_examples.repositories.EnglishGreetingRepository;
import com.prakhar.practise.di_examples.repositories.EnglishGreetingRepositoryImpl;
import com.prakhar.practise.di_examples.services.*;
import com.prakhar.practise.pets.PetService;
import com.prakhar.practise.pets.PetServiceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;


@PropertySource("classpath:datasource.properties")
@ImportResource("classpath:di-examples-config.xml")
@Configuration
public class GreetingServiceConfig {

    @Bean
    FakeDataSource fakeDataSource(@Value("${prakhar.username}") String username,
                                  @Value("${prakhar.password}")String password,
                                  @Value("${prakhar.jdbcurl}")String jdbcurl){
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUsername(username);
        fakeDataSource.setPassword(password);
        fakeDataSource.setJdbcurl(jdbcurl);
        return fakeDataSource;
    }

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
