package org.omnifaces.procdi.decorators.greeting.qualified.any;

import java.util.logging.Logger;

import javax.enterprise.inject.se.SeContainerInitializer;
import javax.inject.Inject;

public class QualifiedDelegateDemo {

	private static final Logger logger = Logger.getLogger(QualifiedDelegateDemo.class.getName());

	@Inject
	@Language("English")
	private GreetingInterface englishGreetingBean;

	@Inject
	@Language("Dutch")
	private GreetingInterface dutchGreetingBean;

	public void run() {
		logger.info(englishGreetingBean.getHelloMessage("world"));

		logger.info(dutchGreetingBean.getHelloMessage("wereld"));
	}

	public static void main(String[] args) {
		try (var container = SeContainerInitializer.newInstance().initialize()) {
			container.select(QualifiedDelegateDemo.class).get().run();
		}
	}
}
