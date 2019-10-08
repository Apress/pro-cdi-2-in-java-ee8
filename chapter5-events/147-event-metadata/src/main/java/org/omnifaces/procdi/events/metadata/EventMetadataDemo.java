package org.omnifaces.procdi.events.metadata;

import javax.enterprise.event.Event;
import javax.enterprise.inject.se.SeContainerInitializer;
import javax.inject.Inject;

public class EventMetadataDemo {
	@Inject
	@ParameterizedQualifier(name = "foo")
	private Event<String> parameterizedEvent;

	@Inject
	@MyQualifier
	private Event<String> event;

	public void fireEvents() {
		event.fire("bar");

		parameterizedEvent.fire("baz");
	}

	public static void main(String[] args) {
		try (var container = SeContainerInitializer.newInstance().initialize()) {
			container.select(EventMetadataDemo.class).get().fireEvents();
		}
	}
}
