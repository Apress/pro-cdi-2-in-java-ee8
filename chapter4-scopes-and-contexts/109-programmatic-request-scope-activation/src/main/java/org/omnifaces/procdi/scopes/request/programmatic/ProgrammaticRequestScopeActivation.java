package org.omnifaces.procdi.scopes.request.programmatic;

import java.util.logging.Logger;

import javax.enterprise.context.control.RequestContextController;
import javax.inject.Inject;

import org.omnifaces.procdi.scopes.common.MyRequestScopedBean;

public class ProgrammaticRequestScopeActivation {

	private static final Logger logger = Logger.getLogger(ProgrammaticRequestScopeActivation.class.getName());

	@Inject
	private MyRequestScopedBean myRequestScopedBean;

	@Inject
	private RequestContextController requestContextController;

	public void doSomethingWithRequestScope() {
		boolean activated = requestContextController.activate();

		if (activated) {
			logger.info("New request scope activated");
		}

		try {
			myRequestScopedBean.doSomething();
		}
		finally {
			requestContextController.deactivate();
		}
	}
}
