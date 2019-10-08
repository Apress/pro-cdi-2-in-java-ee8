package org.omnifaces.procdi.scopes.common;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class MyRequestScopedBean {

	public void doSomething() {
		System.out.println("Hello world!");
	}
}
