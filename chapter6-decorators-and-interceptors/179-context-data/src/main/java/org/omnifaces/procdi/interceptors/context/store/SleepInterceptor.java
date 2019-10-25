package org.omnifaces.procdi.interceptors.context.store;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 * Interceptor that sleeps for 2 seconds before resuming the invocation chain.
 */
@Interceptor
public class SleepInterceptor {

	@AroundInvoke
	public Object aroundInvoke(InvocationContext context) throws Exception {
		Thread.sleep(2000);
		return context.proceed();
	}
}
