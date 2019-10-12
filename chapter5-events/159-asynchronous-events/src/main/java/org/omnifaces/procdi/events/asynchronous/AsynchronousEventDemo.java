package org.omnifaces.procdi.events.asynchronous;

import javax.enterprise.inject.se.SeContainerInitializer;

public class AsynchronousEventDemo {


	public static void main(String[] args) {
		try (var container = SeContainerInitializer.newInstance().initialize()) {
			var asynchronousEventFiringBean = container.select(AsynchronousEventFiringBean.class).get();

			asynchronousEventFiringBean.fireEvent("Test event");
		}
	}
}
