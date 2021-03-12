package com.prakhar.practise.di_examples.services;

import com.prakhar.practise.di_examples.repositories.EnglishGreetingRepository;
import com.prakhar.practise.di_examples.repositories.EnglishGreetingRepositoryImpl;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

public class I18nEnglishGreetingService implements GreetingService{

    private final EnglishGreetingRepository englishGreetingRepository;

    public I18nEnglishGreetingService(EnglishGreetingRepository englishGreetingRepository) {
        this.englishGreetingRepository = englishGreetingRepository;
    }

    @Override
    public String sayGreeting() {
        return "Hello World -EN";
    }
}
