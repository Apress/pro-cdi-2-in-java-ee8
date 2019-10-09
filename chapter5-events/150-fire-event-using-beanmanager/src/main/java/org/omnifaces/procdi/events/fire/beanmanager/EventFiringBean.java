package org.omnifaces.procdi.events.fire.beanmanager;

import javax.enterprise.event.Event;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.util.AnnotationLiteral;
import javax.inject.Inject;

public class EventFiringBean {

	public abstract class FooLiteral extends AnnotationLiteral<Foo> implements Foo {
	}

	@Inject
	private BeanManager beanManager;

	public void fireEvent() {
		Event<String> event =
				beanManager.getEvent().select(String.class, new FooLiteral() {
				});

		event.fire("Event object obtained through BeanManager");
	}

}
