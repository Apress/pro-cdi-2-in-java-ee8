package org.omnifaces.procdi.decorators.greeting;

import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.omnifaces.procdi.common.testing.CdiTestExtension;

@ExtendWith(CdiTestExtension.class)
class GreetingDecoratorBeanTest {

	@Inject
	private GreetingBean greetingBean;

	@Test
	void getGreetingMessage() {
		var greeting = greetingBean.getGreetingMessage("world");
		assertTrue(greeting.startsWith("Hello, world! The time is now"));
	}
}