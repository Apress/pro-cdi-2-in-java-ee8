package org.omnifaces.procdi.interceptors.context.store;

import java.time.Instant;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
public class ContextDataWritingInterceptor {

	@AroundInvoke
	public Object aroundInvoke(InvocationContext context) throws Exception {
		Instant startTime = Instant.now();
		context.getContextData().put("startTime", startTime);
		return context.proceed();
	}
}
