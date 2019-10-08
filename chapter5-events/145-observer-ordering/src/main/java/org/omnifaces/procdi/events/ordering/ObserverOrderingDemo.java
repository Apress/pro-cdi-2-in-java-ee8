package org.omnifaces.procdi.events.ordering;

import javax.enterprise.inject.se.SeContainerInitializer;

public class ObserverOrderingDemo {

	public static void main(String[] args) {
		try (var container= SeContainerInitializer.newInstance().initialize()) {
			var beanManager = container.getBeanManager();

			beanManager.getEvent().fire("application event");
		}
	}
}
