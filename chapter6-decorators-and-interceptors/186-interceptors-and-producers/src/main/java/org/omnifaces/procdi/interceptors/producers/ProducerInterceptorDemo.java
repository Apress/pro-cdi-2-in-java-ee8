package org.omnifaces.procdi.interceptors.producers;

import java.util.List;

import javax.enterprise.inject.se.SeContainerInitializer;
import javax.inject.Inject;

public class ProducerInterceptorDemo {

	@Inject
	private List<Number> numberList;

	public void run() {
		System.out.println(numberList.size() + " numbers were injected");
	}

	public static void main(String[] args) {
		try (var container = SeContainerInitializer.newInstance().initialize()) {
			container.select(ProducerInterceptorDemo.class).get().run();
		}
	}
}
