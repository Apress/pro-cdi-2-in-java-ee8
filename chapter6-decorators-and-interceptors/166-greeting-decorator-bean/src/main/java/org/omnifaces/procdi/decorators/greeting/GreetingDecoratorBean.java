package org.omnifaces.procdi.decorators.greeting;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

@Decorator
public abstract class GreetingDecoratorBean implements GreetingInterface {

	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofLocalizedTime(FormatStyle.FULL);

	@Inject
	@Delegate
	private GreetingInterface greetingInterface;

	@Override
	public String getGreetingMessage(String name) {
		return greetingInterface.getGreetingMessage(name) + " The time is now " + FORMATTER.format(ZonedDateTime.now());
	}
}
