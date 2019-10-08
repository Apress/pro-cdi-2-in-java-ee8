package org.omnifaces.procdi.scopes.override;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomSessionScopeContextTest {

	private SeContainer seContainer;
	private CustomSessionScopeContext context;

	@BeforeEach
	public void init() {
		seContainer = SeContainerInitializer.newInstance()
		                                    .initialize();
		context = CustomSessionScopeContext.getInstance();
	}

	@Test
	public void test() {
		context.start("foo");
		seContainer.select(SessionScopedTestBean.class).get().logHelloSessionScope();
		context.suspend();
	}

	@AfterEach
	public void destroy() {
		seContainer.close();
	}
}