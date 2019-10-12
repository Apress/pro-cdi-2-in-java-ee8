package org.omnifaces.procdi.events.generic;

import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.se.SeContainerInitializer;
import javax.inject.Inject;

public class GenericEventDemo {

	private static final Logger logger = Logger.getLogger(GenericEventDemo.class.getName());

	@Inject
	private Event<Object> event;

	@Inject
	private Event<List<String>> stringListEvent;

	public void run() {
		var strings = List.of("a", "b", "c");

		try {
			// Firing an event type with a generic parameter will cause an exception to be thrown.
			event.fire(strings);
		} catch(Exception e) {
			e.printStackTrace();
		}

		// Introducing a wrapper with a hard-coded generic type, will allow the event to be fired.
		event.fire(new StringList(strings));

		// However, firing with an injected event with the correct generic parameter works as well.
		event.fire(strings);
	}

	public void onEvent(@Observes List<String> strings) {
		logger.info("Observed event: " + strings);
	}

	public static void main(String[] args) {
		try (var container= SeContainerInitializer.newInstance().initialize()) {
			container.select(GenericEventDemo.class).get().run();
		}
	}
}
