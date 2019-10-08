package org.omnifaces.procdi.scopes.customscope;

import java.util.UUID;

import javax.enterprise.inject.se.SeContainerInitializer;

public class CustomScopeDemo {

	public static void main(String[] args) {
		try (var container = SeContainerInitializer.newInstance().initialize()) {
			var beanManager = container.getBeanManager();
			var scopeId = UUID.randomUUID().toString();

			CustomScopeContext context = CustomScopeContext.getInstance();
			context.start(scopeId);
			try {
				// Use scoped beans
				var customScopedBean = container.select(CustomScopedBean.class).get();
				customScopedBean.logHelloWorld();

				context.suspend();
			} finally {
				context.destroy(scopeId);
			}

		}
	}
}
