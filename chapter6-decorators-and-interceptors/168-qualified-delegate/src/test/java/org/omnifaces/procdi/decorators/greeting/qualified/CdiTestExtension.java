package org.omnifaces.procdi.decorators.greeting.qualified;

import java.util.UUID;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestInstanceFactory;
import org.junit.jupiter.api.extension.TestInstanceFactoryContext;
import org.junit.jupiter.api.extension.TestInstantiationException;

/**
 * Test instance factory that uses a CDI container to create the test class instances.
 */
public class CdiTestExtension implements TestInstanceFactory {

	private static final ExtensionContext.Namespace EXTENSION_NAMESPACE = ExtensionContext.Namespace.create(CdiTestExtension.class);

	/**
	 * Helper class that allows the CDI container started for a test to be automatically closed after the test have been run.
	 */
	private static class ContainerResource implements ExtensionContext.Store.CloseableResource {
		private final SeContainer container;

		private ContainerResource(SeContainer container) {
			this.container = container;
		}

		public SeContainer getContainer() {
			return container;
		}

		@Override
		public void close() throws Throwable {
			container.close();
		}
	}

	@Override
	public Object createTestInstance(TestInstanceFactoryContext testInstanceFactoryContext, ExtensionContext extensionContext)
			throws TestInstantiationException {
		var container = SeContainerInitializer.newInstance().initialize();

		var store = extensionContext.getStore(EXTENSION_NAMESPACE);

		var testInstanceId = UUID.randomUUID().toString();
		// Store the CDI container in the test context so it can be closed automatically.
		store.put(testInstanceId, new ContainerResource(container));

		return container.select(testInstanceFactoryContext.getTestClass()).get();
	}
}
