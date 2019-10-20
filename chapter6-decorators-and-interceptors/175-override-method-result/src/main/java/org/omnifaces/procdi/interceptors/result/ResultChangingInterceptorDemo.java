package org.omnifaces.procdi.interceptors.result;

import java.util.logging.Logger;

import javax.enterprise.inject.se.SeContainerInitializer;
import javax.interceptor.Interceptors;

@Interceptors(ResultChangingInterceptor.class)
public class ResultChangingInterceptorDemo {

	private static final Logger logger = Logger.getLogger(ResultChangingInterceptorDemo.class.getName());

	public String getHelloWorld() {
		return "Hello, world!";
	}

	public static void main(String[] args) {
		try (var container = SeContainerInitializer.newInstance().initialize()) {
			var demo = container.select(ResultChangingInterceptorDemo.class).get();

			logger.info(demo.getHelloWorld());
		}
	}
}
