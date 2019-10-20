package org.omnifaces.procdi.interceptors.parameters;

import javax.enterprise.inject.se.SeContainerInitializer;
import javax.interceptor.Interceptors;

@Interceptors(UpdateParametersInterceptor.class)
public class UpdateParametersInterceptorDemo {

	public void printString(String s) {
		System.out.println(s);
	}

	public static void main(String[] args) {
		try (var container = SeContainerInitializer.newInstance().initialize()) {
			container.select(UpdateParametersInterceptorDemo.class).get().printString("Hello, world!");
		}
	}
}
