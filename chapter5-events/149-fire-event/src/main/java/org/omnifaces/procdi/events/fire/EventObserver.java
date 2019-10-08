package org.omnifaces.procdi.events.fire;

import static java.util.logging.Level.INFO;

import java.util.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

@ApplicationScoped
public class EventObserver {

	private static final Logger logger = Logger.getLogger(EventObserver.class.getName());

	public void onFoo(@Observes @Foo String event) {
		logger.log(INFO, "Event received: {0}", new Object[]{event});
	}
}
