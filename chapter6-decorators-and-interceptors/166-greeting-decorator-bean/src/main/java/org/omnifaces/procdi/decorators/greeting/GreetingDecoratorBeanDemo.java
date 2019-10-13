package org.omnifaces.procdi.decorators.greeting;

import javax.enterprise.inject.se.SeContainerInitializer;

public class GreetingDecoratorBeanDemo {

	public static void main(String[] args) {
		try (var container = SeContainerInitializer.newInstance().initialize()) {
			var greetingBean = container.select(GreetingBean.class).get();

			var name = "world";
			System.out.println(greetingBean.getGreetingMessage(name));
			System.out.println(greetingBean.getGoodByeMessage(name));
		}
	}
}
