package org.omnifaces.procdi.interceptors.producers;

import static javax.interceptor.Interceptor.Priority.LIBRARY_BEFORE;

import java.util.logging.Logger;

import javax.annotation.Priority;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@LogAccess
@Priority(LIBRARY_BEFORE)
public class LogAccessInterceptor {

	private static final Logger logger = Logger.getLogger(LogAccessInterceptor.class.getName());

	@AroundInvoke
	public Object logAccess(InvocationContext context) throws Exception {
		var className = context.getTarget().getClass().getName();
		var methodName = context.getMethod().getName();
		logger.info("Entering method " + className + "." + methodName);
		try {
			return context.proceed();
		}
		finally {
			logger.info("Exiting method " + className + "." + methodName);
		}
	}
}
