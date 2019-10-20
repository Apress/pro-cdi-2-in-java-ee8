package org.omnifaces.procdi.interceptors.result;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
public class ResultChangingInterceptor {

	@AroundInvoke
	public Object changeResponseString(InvocationContext context) throws Exception {
		Object result = context.proceed();

		if (result instanceof String) {
			return ((String) result).replace('!', '.');
		}

		// Fallback for when the result isn't a string
		return result;
	}
}
