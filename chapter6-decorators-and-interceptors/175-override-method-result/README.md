# Override method result

Example of using an interceptor to override the result of an intercepted method.

## Class listing

| Page | Class                                                                                                                      | Description                                                                                                                     |
|------|----------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------|
| 175  | [ResultChangingInterceptor](src/main/java/org/omnifaces/procdi/interceptors/result/ResultChangingInterceptor.java)         | Interceptor that checks the result of a method and, if the result is of type string, replaces all exclamation marks by periods. |
| N/A  | [ResultChangingInterceptorDemo](src/main/java/org/omnifaces/procdi/interceptors/result/ResultChangingInterceptorDemo.java) | Demo class that shows the interceptor in action.                                                                                |
| N/A  | [ResultChangingInterceptorTest](src/test/java/org/omnifaces/procdi/interceptors/result/ResultChangingInterceptorTest.java) | Test covering the behaviour of the interceptor.                                                                                 |
