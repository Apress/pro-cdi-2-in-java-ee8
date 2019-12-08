package org.omnifaces.procdi.decorators.greeting.qualified.any;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import javax.annotation.Priority;
import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import javax.interceptor.Interceptor;

@Decorator
@Priority(Interceptor.Priority.APPLICATION + 1)
public abstract class GreetingDecoratorBean implements GreetingInterface {

	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofLocalizedTime(FormatStyle.FULL);

	@Inject
	@Delegate
	@Any
	private GreetingInterface greetingBean;

	@Override
	public String getHelloMessage(String name) {
		return greetingBean.getHelloMessage(name) + " The time is now " + FORMATTER.format(ZonedDateTime.now());
	}
}
