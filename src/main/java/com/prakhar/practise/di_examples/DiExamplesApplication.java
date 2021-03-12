package com.prakhar.practise.di_examples;

import com.prakhar.practise.di_examples.controllers.ConstructorInjectedController;
import com.prakhar.practise.di_examples.controllers.MyController;
import com.prakhar.practise.di_examples.controllers.PropertyInjectedController;
import com.prakhar.practise.di_examples.controllers.SetterInjectedController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DiExamplesApplication {

	public static void main(String[] args) {
		ApplicationContext actx =SpringApplication.run(DiExamplesApplication.class, args);
        //SpringApplication.run() returns an application context
		MyController myController= (MyController)actx.getBean("myController");

		String greeting= myController.sayHello();
		System.out.println(greeting);

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
