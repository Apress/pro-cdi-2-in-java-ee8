package org.omnifaces.procdi.interceptors.result;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.inject.Inject;
import javax.interceptor.Interceptors;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.omnifaces.procdi.common.testing.CdiTestExtension;

@ExtendWith(CdiTestExtension.class)
class ResultChangingInterceptorTest {

	@Interceptors(ResultChangingInterceptor.class)
	public static class TestBean {

		public String getTestString(String result) {
			return result;
		}
	}

	@Inject
	private TestBean testBean;

	@Test
	public void changeResponseString() {
		var result = testBean.getTestString("Hello!");

		assertEquals("Hello.", result);
	}
}