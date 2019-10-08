package org.omnifaces.procdi.scopes.passivation.passivation;

import javax.enterprise.context.spi.Contextual;
import javax.enterprise.context.spi.CreationalContext;

final class BeanInstance<T> {

	private final T instance;
	private final Contextual<T> contextual;
	private final CreationalContext<T> creationalContext;


	BeanInstance(T instance, Contextual<T> contextual, CreationalContext<T> creationalContext) {
		this.instance = instance;
		this.contextual = contextual;
		this.creationalContext = creationalContext;
	}

	T get() {
		return instance;
	}

	void destroy() {
		contextual.destroy(instance, creationalContext);
	}
}
