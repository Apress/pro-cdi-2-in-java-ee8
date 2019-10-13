package org.omnifaces.procdi.events.asynchronous.completionstage;

import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.enterprise.event.ObservesAsync;
import javax.enterprise.inject.se.SeContainerInitializer;
import javax.inject.Inject;

@ApplicationScoped
public class AsyncCompletionStageDemo {

	private static final Logger logger = Logger.getLogger(AsyncCompletionStageDemo.class.getName());

	@Inject
	private Event<String> preResourceDisposalEvent;

	public void run() {
		var resourceId = UUID.randomUUID().toString();
		preResourceDisposalEvent.fireAsync(resourceId)
		                        .handle((id, exception) -> {
			                        if (exception != null) {
				                        for (Throwable suppressed : exception.getSuppressed()) {
					                        logThrowable(suppressed);
				                        }

				                        return resourceId;
			                        }

			                        return id;
		                        })
		                        .thenAccept(id -> closeResource(id));
	}

	private void closeResource(String id) {
		logger.info("Closing resource: " + id);
	}

	private void logThrowable(Throwable throwable) {
		logger.log(Level.INFO, "Throwable thrown while notifying listeners: ", throwable);
	}

	private void throwExceptionOnEvent(@ObservesAsync String resourceId) {
		throw new IllegalArgumentException("Invalid resource ID: " + resourceId);
	}

	public static void main(String[] args) {
		try (var container = SeContainerInitializer.newInstance().initialize()) {
			container.select(AsyncCompletionStageDemo.class).get().run();
		}
	}
}
