package com.prakhar.practise.di_examples;

import com.prakhar.practise.di_examples.controllers.MyController;
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
	}

}
