package org.omnifaces.procdi.interceptors.contructor;

import javax.enterprise.inject.se.SeContainerInitializer;
import javax.inject.Inject;

public class ConstructorInterceptorDemo {

	@Inject
	private MyBean myBean;

	public void run() {
		System.out.println(myBean.toString());
	}

	public static void main(String[] args) {
		try (var container= SeContainerInitializer.newInstance().initialize()) {
			container.select(ConstructorInterceptorDemo.class).get().run();
		}
	}
}
