package org.omnifaces.procdi.interceptors.contructor;

import javax.enterprise.context.ApplicationScoped;

@Timed
@ApplicationScoped
public class MyBean {

	MyBean() {
		sleep(1000);
	}

	@Override
	public String toString() {
		sleep(2000);

		return "This is my bean.";
	}

	private static void sleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}
