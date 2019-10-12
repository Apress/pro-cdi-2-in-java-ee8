package org.omnifaces.procdi.events.asynchronous;

import java.util.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.ObservesAsync;

@ApplicationScoped
public class EventObserver {
	private static final Logger logger = Logger.getLogger(EventObserver.class.getName());

	private void onFooEventAsync(@ObservesAsync @Foo String event) {
		logger.info("Async @Foo event observed: " + event);
	}
}
