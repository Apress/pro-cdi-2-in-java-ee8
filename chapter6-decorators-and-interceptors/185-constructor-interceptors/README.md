# Constructor interceptors

This is an example of how to write an apply a constructor interceptor on a bean. Please note that the interceptor is both a constructor as well as a 
regular method interceptor. 

## Class listing

| Page | Class                                                                                                                    | Description                                                                                                                            |
|------|--------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------|
| 185  | [TimingInterceptor](src/main/java/org/omnifaces/procdi/interceptors/contructor/TimingInterceptor.java)                   | Interceptor that can be applied to constructors that measures the amount of time an invocation takes.                                  |
| N/A  | [Timed](src/main/java/org/omnifaces/procdi/interceptors/contructor/Timed.java)                                           | Interceptor binding annotation for the `TimingInterceptor`.                                                                            |
| N/A  | [MyBean](src/main/java/org/omnifaces/procdi/interceptors/contructor/MyBean.java)                                         | Bean on which the `TimingInterceptor` is applied. This bean simulates work by sleeping in the constructor and the `toString()` method. |
| N/A  | [ConstructorInterceptorDemo](src/main/java/org/omnifaces/procdi/interceptors/contructor/ConstructorInterceptorDemo.java) | Demo class that runs the example.                                                                                                      |
