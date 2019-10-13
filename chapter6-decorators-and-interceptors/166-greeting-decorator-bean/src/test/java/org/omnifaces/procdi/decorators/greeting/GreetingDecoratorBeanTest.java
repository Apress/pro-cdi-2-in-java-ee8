package org.omnifaces.procdi.decorators.greeting;

import static org.junit.jupiter.api.Assertions.*;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GreetingDecoratorBeanTest {

	private SeContainer container;

	@BeforeEach
	private void init() {
		container = SeContainerInitializer.newInstance().initialize();
	}

	@Test
	void getGreetingMessage() {
		var greetingBean = container.select(GreetingBean.class).get();

		var greeting = greetingBean.getGreetingMessage("world");
		assertTrue(greeting.startsWith("Hello, world! The time is now"));
	}

	@AfterEach
	private void cleanUp() {
		container.close();
	}
}