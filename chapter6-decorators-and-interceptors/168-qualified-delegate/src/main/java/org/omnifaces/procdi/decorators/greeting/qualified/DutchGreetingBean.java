package org.omnifaces.procdi.decorators.greeting.qualified;

@Language("Dutch")
public class DutchGreetingBean implements GreetingInterface {
	@Override
	public String getHelloMessage(String name) {
		return "Hallo " + name + "!";
	}

	@Override
	public String getGoodByeMessage(String name) {
		return "Tot ziens " + name + "!";
	}
}
