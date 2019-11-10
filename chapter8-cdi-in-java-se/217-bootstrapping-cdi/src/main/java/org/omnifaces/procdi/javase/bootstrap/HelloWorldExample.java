package org.omnifaces.procdi.javase.bootstrap;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

public class HelloWorldExample {

	public static void main(String[] args) {
		try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {
			GreetingService greetingService = container.select(GreetingService.class).get();

			String greeting = greetingService.generateGreeting("world");
			System.out.println(greeting);
		}
	}
}