package org.omnifaces.procdi.scopes.override;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.enterprise.context.SessionScoped;

@SessionScoped
public class SessionScopedTestBean implements Serializable {
	private static final Logger logger = Logger.getLogger(SessionScopedTestBean.class.getName());

	public void logHelloSessionScope() {
		logger.info("Hello session scope!");
	}
}
