package org.omnifaces.procdi.decorators.greeting.qualified.any;

import static org.junit.jupiter.api.Assertions.*;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.omnifaces.procdi.common.testing.CdiTestExtension;

@ExtendWith(CdiTestExtension.class)
class GreetingDecoratorBeanTest {

	@Inject
	@Language("English")
	private GreetingInterface englishGreetingBean;

	@Inject
	@Language("Dutch")
	private GreetingInterface dutchGreetingBean;

	@Test
	void getEnglishGreetingMessage() {
		var greeting = englishGreetingBean.getHelloMessage("world");
		assertTrue(greeting.startsWith("Hello, world! The time is now"));
	}

	@Test
	void getDutchGreetingMessage() {
		var greeting = dutchGreetingBean.getHelloMessage("wereld");
		assertTrue(greeting.startsWith("Hallo wereld! The time is now"));
	}

}