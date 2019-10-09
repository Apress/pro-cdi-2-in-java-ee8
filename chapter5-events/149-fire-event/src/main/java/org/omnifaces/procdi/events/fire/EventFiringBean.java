package org.omnifaces.procdi.events.fire;

import javax.enterprise.event.Event;
import javax.inject.Inject;

public class EventFiringBean {

	@Inject
	@Foo
	private Event<String> event;

	public void fireEvent(String string) {
		event.fire(string);
	}

}
