package org.omnifaces.procdi.interceptors.context.store;

import javax.enterprise.inject.se.SeContainerInitializer;
import javax.interceptor.Interceptors;

@Interceptors({ContextDataWritingInterceptor.class, SleepInterceptor.class, ContextDataReadingInterceptor.class})
public class ContextDataDemo {

	public void doNothing() {
		/* This method doesn't do anyhing, but when it is call, it displays how long the interceptor chain
		 * between the ContextDataWritingInterceptor and the ContextDataReadingInterceptor.
		 */
	}

	public static void main(String[] args) {
		try (var container = SeContainerInitializer.newInstance().initialize()) {
			container.select(ContextDataDemo.class).get().doNothing();
		}
	}
}
