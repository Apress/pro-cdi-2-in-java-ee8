package org.omnifaces.procdi.scopes.events;

import javax.enterprise.context.control.RequestContextController;
import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

public class RequestScopeEventsDemo {

	public static void main(String[] args) {
		try (SeContainer container = createContainer()) {
			var requestContextController = container.select(RequestContextController.class).get();

			// Create a new request scope, this will fire the @Initialized event.
			requestContextController.activate();


			// Destroy the request scope, this will fire both the @BeforeDestroyed and @Destroyed events.
			requestContextController.deactivate();
		}
	}

	private static SeContainer createContainer() {
		return SeContainerInitializer.newInstance().initialize();
	}
}
