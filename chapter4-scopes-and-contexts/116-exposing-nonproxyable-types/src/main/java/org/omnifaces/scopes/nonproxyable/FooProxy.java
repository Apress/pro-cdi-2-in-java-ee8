package org.omnifaces.scopes.nonproxyable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class FooProxy {

	@Inject
	private FinalFoo dependentScopedBean;

	public void foo() {
		dependentScopedBean.foo();
	}
}
