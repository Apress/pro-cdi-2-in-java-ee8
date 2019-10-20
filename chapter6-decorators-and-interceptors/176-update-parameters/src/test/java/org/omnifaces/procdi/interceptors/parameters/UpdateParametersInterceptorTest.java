package org.omnifaces.procdi.interceptors.parameters;

import static org.junit.jupiter.api.Assertions.*;

import javax.inject.Inject;
import javax.interceptor.Interceptors;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.omnifaces.procdi.common.testing.CdiTestExtension;

@ExtendWith(CdiTestExtension.class)
class UpdateParametersInterceptorTest {

	@Interceptors(UpdateParametersInterceptor.class)
	public static class TestBean {
		public String returnParameter(String s) {
			return s;
		}
	}

	@Inject
	private TestBean testBean;

	@Test
	public void replaceCharsInParameters() {
		assertEquals("foo", testBean.returnParameter("foo"));
		assertEquals("bar.", testBean.returnParameter("bar!"));
	}
}