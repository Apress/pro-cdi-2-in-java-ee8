package org.omnifaces.procdi.scopes.request.interceptor;

import javax.enterprise.context.control.ActivateRequestContext;
import javax.inject.Inject;

import org.omnifaces.procdi.scopes.common.MyRequestScopedBean;

public class InterceptorRequestScopeActivation {

	@Inject
	private MyRequestScopedBean myRequestScopedBean;

	@ActivateRequestContext
	public void doSomethingWithRequestScope() {
		myRequestScopedBean.doSomething();
	}
}
