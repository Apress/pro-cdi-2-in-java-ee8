package org.omnifaces.procdi.scopes.passivation.passivation;

import java.lang.annotation.Annotation;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;

import javax.enterprise.context.ContextNotActiveException;
import javax.enterprise.context.spi.Context;
import javax.enterprise.context.spi.Contextual;
import javax.enterprise.context.spi.CreationalContext;

public class PassivatingCustomScopeContext implements Context {

    private static final ThreadLocal<AtomicReference<String>>
      ACTIVE_SCOPE_THREAD_LOCAL =
      ThreadLocal.withInitial(AtomicReference::new);

    private final ConcurrentHashMap<String, Map<Contextual<?>, BeanInstance<?>>>
      cache = new ConcurrentHashMap<>();

    @Override
    public boolean isActive() {
        return ACTIVE_SCOPE_THREAD_LOCAL.get().get() != null;
    }

    private boolean isScopePresentInStorage(String scopeId) {
        // TODO Currently always returns false as there is no backing storage.
        return false;
    }

    private Optional<ConcurrentHashMap<Contextual<?>, BeanInstance<?>>> loadFromStorage(
      String scopeId) {
        if (isScopePresentInStorage(scopeId)) {
            // Load scope from storage and return
        }

        // Scope isn't present in storage, return new instance map instead
        return Optional.empty();
    }

    private void writeToStorage(String scopeId,
      Map<Contextual<?>, BeanInstance<?>> instanceMap) {
        // Write the scope to storage
    }

    public void passivate(String scopeId) {
        cache.compute(scopeId, (id, instanceMap) -> {
            writeToStorage(id, instanceMap);

            // TODO check if beans need to be destroyed
            instanceMap.values().forEach(BeanInstance::destroy);

            // Return null to remove the instance map from the cache
            return null;
        });
    }

    @Override
    public Class<? extends Annotation> getScope() {
        return PassivatingCustomScoped.class;
    }

    @Override
    public <T> T get(Contextual<T> contextual) {
        String scopeId = ACTIVE_SCOPE_THREAD_LOCAL.get().get();

        if (scopeId == null) {
            throw new ContextNotActiveException();
        }

        @SuppressWarnings("unchecked")
        BeanInstance<T> instance =
          (BeanInstance<T>) cache.computeIfAbsent(scopeId,
            id -> loadFromStorage(id).orElseGet(ConcurrentHashMap::new))
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
        T instance = (T) cache.computeIfAbsent(scopeId,
          id -> loadFromStorage(id).orElseGet(ConcurrentHashMap::new))
          .computeIfAbsent(contextual,
            c -> new BeanInstance<>(contextual.create(creationalContext),
              contextual, creationalContext))
          .get();

        return instance;
    }
}
