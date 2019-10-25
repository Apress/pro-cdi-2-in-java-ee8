package org.omnifaces.procdi.interceptors.context.store;

import java.time.Duration;
import java.time.Instant;
import java.util.logging.Logger;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
public class ContextDataReadingInterceptor {
	private static final Logger logger = Logger.getLogger(ContextDataReadingInterceptor.class.getName());

	@AroundInvoke
	public Object aroundInvoke(InvocationContext context) throws Exception {
		Object startTime = context.getContextData().get("startTime");
		if (startTime instanceof Instant) {
			Duration duration = Duration.between((Instant) startTime, Instant.now());

			logger.info("Execution took " + duration.toMillis() + "ms.");
		}

		return context.proceed();
	}
}
