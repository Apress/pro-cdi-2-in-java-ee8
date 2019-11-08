# Interceptors & producers

Demo of adding interceptors to an object instance created by a producer method instead of by the CDI container.

## Class listing

| Page | Class                                                                                                             | Description                                                                                         |
|------|-------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------|
| 186  | [Producers](src/main/java/org/omnifaces/procdi/interceptors/producers/Producers.java)                             | Producer that creates a list of numbers for injection and that applies an interceptor to this list. |
| N/A  | [LogAccess](src/main/java/org/omnifaces/procdi/interceptors/producers/LogAccess.java)                             | Interceptor binding annotation that indicates that access to a class or method must be logged.      |
| N/A  | [LogAccessInterceptor](src/main/java/org/omnifaces/procdi/interceptors/producers/LogAccessInterceptor.java)       | Interceptor that logs any access to an intercepted class or method.                                 |
| N/A  | [ProducerInterceptorDemo](src/main/java/org/omnifaces/procdi/interceptors/producers/ProducerInterceptorDemo.java) | Demo showing the application of interceptors on classes created in a producer method.               |
