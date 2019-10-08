package org.omnifaces.procdi.scopes.customscope;

import java.lang.annotation.Annotation;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;

import javax.enterprise.context.ContextNotActiveException;
import javax.enterprise.context.spi.Context;
import javax.enterprise.context.spi.Contextual;
import javax.enterprise.context.spi.CreationalContext;

public class CustomScopeContext implements Context {

	private static final CustomScopeContext INSTANCE = new CustomScopeContext();

	private static final ThreadLocal<AtomicReference<String>>
			ACTIVE_SCOPE_THREAD_LOCAL =
			ThreadLocal.withInitial(AtomicReference::new);

	private final ConcurrentHashMap<String, Map<Contextual<?>, BeanInstance<?>>>
			cache = new ConcurrentHashMap<>();

	private CustomScopeContext() {
	}

	public static CustomScopeContext getInstance(){
		return INSTANCE;
	}

	@Override
	public boolean isActive() {
		return ACTIVE_SCOPE_THREAD_LOCAL.get().get() != null;
	}

	public void start(String scopeId) {
		AtomicReference<String> activeScope =
				ACTIVE_SCOPE_THREAD_LOCAL.get();

		if (activeScope.get() != null) {
			throw new IllegalStateException(
					"An instance of the scope is already active");
		}

		activeScope.set(scopeId);
	}

	public void suspend() {
		AtomicReference<String> activeScope =
				ACTIVE_SCOPE_THREAD_LOCAL.get();

		if (activeScope.get() == null) {
			throw new IllegalStateException("Scope not currently active!");
		}

		activeScope.set(null);
	}

	@Override
	public Class<? extends Annotation> getScope() {
		return CustomScope.class;
	}

	@Override
	public <T> T get(Contextual<T> contextual) {
		String scopeId = ACTIVE_SCOPE_THREAD_LOCAL.get().get();

		if (scopeId == null) {
			throw new ContextNotActiveException();
		}

		@SuppressWarnings("unchecked")
		BeanInstance<T> instance =
				(BeanInstance<T>) cache.getOrDefault(scopeId, Map.of())
				                       .get(contextual);

		if (instance == null) {
			return null;
		}

		return instance.get();
	}

	@Override
	public <T> T get(Contextual<T> contextual,
			CreationalContext<T> creationalContext) {
		String scopeId = ACTIVE_SCOPE_THREAD_LOCAL.get().get();

		if (scopeId == null) {
			throw new ContextNotActiveException();
		}

		@SuppressWarnings("unchecked")
		T instance = (T) cache
				.computeIfAbsent(scopeId, s -> new ConcurrentHashMap<>())
				.computeIfAbsent(contextual,
				                 c -> new BeanInstance<>(
						                 contextual.create(creationalContext), contextual,
						                 creationalContext))
				.get();

		return instance;
	}

	public void destroy(String scopeId) {
		Map<Contextual<?>, BeanInstance<?>> instances =
				cache.remove(scopeId);

		if (instances != null) {
			instances.values()
			         .forEach(BeanInstance::destroy);
		}
	}
}
