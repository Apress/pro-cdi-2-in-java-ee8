package org.omnifaces.procdi.events.ordering;

import javax.annotation.Priority;
import javax.enterprise.event.Observes;
import javax.interceptor.Interceptor;

public class LibraryObserver {
	public void libraryBeforeObserver(@Observes @Priority(
			Interceptor.Priority.LIBRARY_BEFORE) Object eventObject) {
		System.out.println("Called before application: " + eventObject);
	}

	public void libraryAfterObserver(@Observes @Priority(
			Interceptor.Priority.LIBRARY_AFTER) Object eventObject) {
		System.out.println("Called after application: " + eventObject);
	}
}
