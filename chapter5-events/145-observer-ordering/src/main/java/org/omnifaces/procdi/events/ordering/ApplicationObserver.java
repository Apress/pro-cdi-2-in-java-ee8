package org.omnifaces.procdi.events.ordering;

import javax.annotation.Priority;
import javax.enterprise.event.Observes;
import javax.interceptor.Interceptor;

public class ApplicationObserver {

	public void firstObserver(@Observes @Priority(
			Interceptor.Priority.APPLICATION) Object eventObject) {
		System.out.println("Called first: " + eventObject);
	}

	public void secondObserver(@Observes @Priority(
			Interceptor.Priority.APPLICATION + 5) Object eventObject) {
		System.out.println("Called second: " + eventObject);
	}

	public void thirdObserver(@Observes Object eventObject) {
		System.out.println("Called third: " + eventObject);
	}
}
