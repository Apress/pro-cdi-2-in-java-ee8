package org.omnifaces.procdi.scopes.customscope;

import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CustomScopeTest {

	private SeContainer container;

	@BeforeEach
	private void setUp() {
		container = SeContainerInitializer.newInstance().initialize();
	}

	@Test
	@DisplayName("Accessing a custom scoped bean, while the scope is not active, throws an exception.")
	public void accessingCustomScopedBean_whenScopeNotActive_throwsException() {
		var customScopedBean = container.select(CustomScopedBean.class).get();

		assertThrows(Exception.class, () -> customScopedBean.logHelloWorld());
	}

	@Test
	@DisplayName("Accessing a custom scoped bean, while the scope is active, succeeds.")
	public void accessingCustomScopedBean_whenScopeIsActive_succeeds() {
		var customScopedBean = container.select(CustomScopedBean.class).get();

		var customScopeContext = CustomScopeContext.getInstance();

		var scopeId = UUID.randomUUID().toString();

		customScopeContext.start(scopeId);

		customScopedBean.logHelloWorld();

		customScopeContext.suspend();
		customScopeContext.destroy(scopeId);
	}

	@Test
	@DisplayName("Accessing a custom scoped bean, after the scope has been suspended, throws an exception.")
	public void accessingCustomScopedBean_whenScopeIsSuspended_throwsException() {
		var customScopedBean = container.select(CustomScopedBean.class).get();

		var customScopeContext = CustomScopeContext.getInstance();

		var scopeId = UUID.randomUUID().toString();

		customScopeContext.start(UUID.randomUUID().toString());

		customScopeContext.suspend();

		assertThrows(Exception.class, () -> customScopedBean.logHelloWorld());

		customScopeContext.destroy(scopeId);
	}

	@Test
	@DisplayName("Accessing a custom scoped bean, after the scope has been resumed, uses the same instance.")
	public void accessingCustomScopedBean_whenScopeIsResumed_usesSameInstance() {
		var customScopedBean = container.select(CustomScopedBean.class).get();

		var customScopeContext = CustomScopeContext.getInstance();

		var scopeId = UUID.randomUUID().toString();

		customScopeContext.start(scopeId);

		var expectedBeanId = customScopedBean.getBeanId();

		customScopeContext.suspend();

		customScopeContext.start(scopeId);

		assertEquals(expectedBeanId, customScopedBean.getBeanId());

		customScopeContext.suspend();
		customScopeContext.destroy(scopeId);
	}

	@Test
	@DisplayName("Accessing a custom scoped bean, after the scope has been destroyed, throws an exception.")
	public void accessingCustomScopedBean_whenScopeIsDestroyed_throwsException() {
		var customScopedBean = container.select(CustomScopedBean.class).get();

		var customScopeContext = CustomScopeContext.getInstance();

		var scopeId = UUID.randomUUID().toString();

		customScopeContext.start(scopeId);

		customScopeContext.suspend();
		customScopeContext.destroy(scopeId);

		assertThrows(Exception.class, () -> customScopedBean.logHelloWorld());
	}

	@Test
	@DisplayName("Accessing a custom scoped bean, when a different scope has been started, uses a different bean instance.")
	public void accessingCustomScopedBean_whenDifferentScopeIsStarted_usesDifferentBeanInstance() {
		var customScopedBean = container.select(CustomScopedBean.class).get();

		var customScopeContext = CustomScopeContext.getInstance();

		var scopeId1 = UUID.randomUUID().toString();
		var scopeId2 = UUID.randomUUID().toString();

		customScopeContext.start(scopeId1);

		var oldBeanId = customScopedBean.getBeanId();
		customScopeContext.suspend();
		customScopeContext.destroy(scopeId1);


		customScopeContext.start(scopeId2);

		assertNotEquals(oldBeanId, customScopedBean.getBeanId());

		customScopeContext.suspend();
		customScopeContext.destroy(scopeId2);
	}

	@AfterEach
	private void tearDown() {
		container.close();
	}

}