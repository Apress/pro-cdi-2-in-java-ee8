package org.omnifaces.procdi.interceptors.caching;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
public class CachingInterceptor {

	private final ConcurrentHashMap<List<Object>, Object> cache = new ConcurrentHashMap<>();

	@AroundInvoke
	public Object aroundInvoke(InvocationContext context) throws Exception {
		// Make an immutable copy of the parameters to use as cache key.
		List<Object> parameters = List.copyOf(Arrays.asList(context.getParameters()));

		if (cache.containsKey(parameters)) {
			return cache.get(parameters);
		}

		Object result = context.proceed();

		cache.put(parameters, result);

		return result;
	}
}
