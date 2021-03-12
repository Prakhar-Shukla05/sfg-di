package com.prakhar.practise.pets;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("cat")
public class CatPerService implements PetService{
    @Override
    public String getPetType() {
        return "Cats Are the Best!";
    }
}
