package org.omnifaces.procdi.scopes.customscope;

import java.util.UUID;
import java.util.logging.Logger;

@CustomScope
public class CustomScopedBean {
	private static final Logger logger = Logger.getLogger(CustomScopedBean.class.getName());

	private final String beanId = UUID.randomUUID().toString();

	public void logHelloWorld() {
		logger.info("Hello, world from the custom scope!");
	}

	public String getBeanId() {
		return beanId;
	}
}
