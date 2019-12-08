package org.omnifaces.procdi.decorators.greeting.qualified.any;

@Language("English")
public class EnglishGreetingBean implements GreetingInterface {
	@Override
	public String getHelloMessage(String name) {
		return  "Hello, " + name + "!";
	}

	@Override
	public String getGoodByeMessage(String name) {
		return "Good bye, " + name + "!";
	}
}
