package org.omnifaces.procdi.interceptors.caching;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.atomic.AtomicLong;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import javax.interceptor.Interceptors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CachingInterceptorTest {

	private SeContainer container;

	@Interceptors(CachingInterceptor.class)
	public static class TestBean {
		private AtomicLong counter = new AtomicLong();

		public long incrementCount(String argument) {
			return counter.getAndIncrement();
		}
	}
	@BeforeEach
	public void init() {
		container = SeContainerInitializer.newInstance().initialize();
	}

	@Test
	public void aroundInvoke() {
		var testBean = container.select(TestBean.class).get();

		assertEquals(0, testBean.incrementCount("Foo"));
		assertEquals(0, testBean.incrementCount("Foo"));
		assertEquals(1, testBean.incrementCount("Bar"));
		assertEquals(1, testBean.incrementCount("Bar"));
		assertEquals(0, testBean.incrementCount("Foo"));
	}



}