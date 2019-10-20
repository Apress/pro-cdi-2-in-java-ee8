package org.omnifaces.procdi.interceptors.caching;

import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Logger;

import javax.enterprise.inject.se.SeContainerInitializer;
import javax.interceptor.Interceptors;

public class CachingInterceptorDemo {
	private static final Logger logger = Logger.getLogger(CachingInterceptorDemo.class.getName());

	@Interceptors(CachingInterceptor.class)
	public int getRandomNumber() {
		var random = ThreadLocalRandom.current().nextInt();

		logger.info("Generated random number: " + random);

		return random;
	}

	public static void main(String[] args) {
		try (var container = SeContainerInitializer.newInstance().initialize()) {
			var cachingInterceptorDemo = container.select(CachingInterceptorDemo.class).get();

			logger.info("Received number: " + cachingInterceptorDemo.getRandomNumber());

			logger.info("Received number: " + cachingInterceptorDemo.getRandomNumber());

		}
	}
}
