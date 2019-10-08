package org.omnifaces.procdi.events.fire;

import javax.enterprise.inject.se.SeContainerInitializer;

public class EventFiringDemo {

	public static void main(String[] args) {
		try (var container = SeContainerInitializer.newInstance().initialize()) {
			var eventFiringBean = container.select(EventFiringBean.class).get();

			eventFiringBean.fireEvent("test event");

			eventFiringBean.fireEventThroughBeanManager();
		}
	}
}
