package org.omnifaces.scopes.nonproxyable;

import java.util.logging.Logger;

public final class FinalFoo {

	private static final Logger logger = Logger.getLogger(FinalFoo.class.getName());

	public void foo() {
		logger.info("Hello world.");
	}
}
