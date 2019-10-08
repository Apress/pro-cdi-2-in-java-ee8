package org.omnifaces.procdi.scopes.override;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.AfterBeanDiscovery;
import javax.enterprise.inject.spi.Extension;

public class CustomSessionScopeContextExtension implements Extension {

	private CustomSessionScopeContext context;

	public CustomSessionScopeContext getContext() {
		return context;
	}

	public void afterBeanDiscovery(@Observes AfterBeanDiscovery abd) {
		abd.addContext(CustomSessionScopeContext.getInstance());
	}
}
