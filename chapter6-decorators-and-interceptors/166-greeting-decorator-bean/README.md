# Greeting Bean Decorator

This demo shows how to apply a decorator to a bean.

## Class listings

| Page | Class                                                                                                             | Description                                                                 |
|------|-------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------|
| 166  | [GreetingBean](src/main/java/org/omnifaces/procdi/decorators/greeting/GreetingBean.java)                          | Bean that generates a simple greeting message                               |
| 167  | [GreetingDecoratorBean](src/main/java/org/omnifaces/procdi/decorators/greeting/GreetingDecoratorBean.java)        | Decorator that overrides the getGreetingMessage() method on `GreetingBean`. |
| N/A  | [GreetingDecoratoreanDemo](src/main/java/org/omnifaces/procdi/decorators/greeting/GreetingDecoratorBeanDemo.java) | Class that sets up and runs the demo.                                       |
| N/A  | [GreetingInterface](src/main/java/org/omnifaces/procdi/decorators/greeting/GreetingInterface.java)                | Interface that defines the main methods in `GreetingBean`.                  |
