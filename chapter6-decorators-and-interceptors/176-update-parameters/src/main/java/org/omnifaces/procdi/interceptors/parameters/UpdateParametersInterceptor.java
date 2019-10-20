package org.omnifaces.procdi.interceptors.parameters;

import java.util.Arrays;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
public class UpdateParametersInterceptor {

	@AroundInvoke
	public Object replaceCharsInParameters(InvocationContext context) throws Exception {
		Object[] parameters = context.getParameters();
		if (parameters.length > 0) {
			Object[] newParameters = Arrays.stream(parameters)
			                               .map(parameter -> {
				                               if (parameter instanceof String) {
					                               return ((String) parameter).replace('!', '.');
				                               }

				                               return parameter;
			                               }).toArray();

			context.setParameters(newParameters);
		}

		return context.proceed();
	}
}
