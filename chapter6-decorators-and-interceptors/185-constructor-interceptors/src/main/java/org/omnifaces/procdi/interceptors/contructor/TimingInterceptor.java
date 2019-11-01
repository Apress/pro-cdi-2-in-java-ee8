package org.omnifaces.procdi.interceptors.contructor;

import static javax.interceptor.Interceptor.Priority.LIBRARY_BEFORE;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import javax.annotation.Priority;
import javax.interceptor.AroundConstruct;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Timed
@Interceptor
@Priority(LIBRARY_BEFORE)
public class TimingInterceptor {

	private static final Logger logger = Logger.getLogger(TimingInterceptor.class.getName());

	@AroundInvoke
	@AroundConstruct
	Object measureInvocation(InvocationContext context) throws Exception {
		long start = System.nanoTime();
		try {
			return context.proceed();
		} finally {
			long stop = System.nanoTime();
			if (context.getConstructor() != null) {
				logger.info(context.getConstructor() + " took " + TimeUnit.NANOSECONDS.toMillis(stop - start) + "ms.");
			}
			else {
				logger.info(context.getMethod() + " took " + TimeUnit.NANOSECONDS.toMillis(stop - start) + "ms.");
			}
		}
	}
}

