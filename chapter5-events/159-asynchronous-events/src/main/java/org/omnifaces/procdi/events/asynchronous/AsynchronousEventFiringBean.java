package org.omnifaces.procdi.events.asynchronous;

import javax.enterprise.event.Event;
import javax.inject.Inject;

public class AsynchronousEventFiringBean {

	@Inject
	@Foo
	private Event<String> event;

	public void fireEvent(String string) {
		event.fireAsync(string);
	}

}
