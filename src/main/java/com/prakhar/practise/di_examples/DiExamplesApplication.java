package com.prakhar.practise.di_examples;

import com.prakhar.practise.di_examples.controllers.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DiExamplesApplication {

	public static void main(String[] args) {
		ApplicationContext actx =SpringApplication.run(DiExamplesApplication.class, args);
        //SpringApplication.run() returns an application context

		PetController petController = actx.getBean("petController", PetController.class);
		System.out.println("--- The Best Pet is ---");
		System.out.println(petController.whichPetIsTheBest());

		I18nController i18nController= (I18nController) actx.getBean("i18nController");

		System.out.println(i18nController.getGreeting());

		MyController myController= (MyController)actx.getBean("myController");

        System.out.println("--------- Primary Bean");

		System.out.println(myController.getGreeting());

		System.out.println("--------- Property Injected Controller");

		PropertyInjectedController propertyInjectedController= (PropertyInjectedController) actx.getBean("propertyInjectedController");

		System.out.println(propertyInjectedController.getGreeting());

		System.out.println("--------- Setter Injected Controller");

		SetterInjectedController setterInjectedController= (SetterInjectedController)actx.getBean("setterInjectedController");

		System.out.println(setterInjectedController.getGreeting());

		System.out.println("--------- Constructor Injected Controller");

		ConstructorInjectedController constructorInjectedController= (ConstructorInjectedController) actx.getBean("constructorInjectedController");

		System.out.println(constructorInjectedController.getGreeting());
	}

}
