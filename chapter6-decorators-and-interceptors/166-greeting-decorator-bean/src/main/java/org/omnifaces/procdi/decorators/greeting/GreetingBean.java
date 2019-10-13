package org.omnifaces.procdi.decorators.greeting;

public class GreetingBean implements GreetingInterface {

	@Override
	public String getGreetingMessage(String name) {
		return "Hello, " + name + "!";
	}

	@Override
	public String getGoodByeMessage(String name) {
		return "Good bye, " + name + "!";
	}
}
