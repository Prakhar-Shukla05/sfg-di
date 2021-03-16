package com.prakhar.practise.di_examples;

import com.prakhar.practise.di_examples.config.PrakharConfiguration;
import com.prakhar.practise.di_examples.controllers.*;
import com.prakhar.practise.di_examples.datasource.FakeDataSource;
import com.prakhar.practise.di_examples.services.PrototypeBean;
import com.prakhar.practise.di_examples.services.SingletonBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

//@ComponentScan(basePackages ={"com.prakhar.practise.di_examples","com.prakhar.practise.pets"} )
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

		System.out.println("--------- Bean Scopes");

		SingletonBean singletonBean1= (SingletonBean)actx.getBean(SingletonBean.class);
		System.out.println(singletonBean1.getScope());
		SingletonBean singletonBean2= (SingletonBean)actx.getBean(SingletonBean.class);
		System.out.println(singletonBean2.getScope());

		PrototypeBean prototypeBean1= (PrototypeBean) actx.getBean(PrototypeBean.class);
		System.out.println(prototypeBean1.getScope());
		PrototypeBean prototypeBean2= (PrototypeBean) actx.getBean(PrototypeBean.class);
		System.out.println(prototypeBean2.getScope());

		System.out.println("--------- Property Source Example");
		FakeDataSource fakeDataSource= actx.getBean(FakeDataSource.class);
		System.out.println(fakeDataSource.getUsername());
		System.out.println(fakeDataSource.getPassword());
		System.out.println(fakeDataSource.getJdbcurl());

		System.out.println("--------- Config Props Bean");
		PrakharConfiguration prakharConfiguration = (PrakharConfiguration) actx.getBean(PrakharConfiguration.class);
		System.out.println(prakharConfiguration.getUsername());
		System.out.println(prakharConfiguration.getPassword());
		System.out.println(prakharConfiguration.getJdbcurl());
	}

}
