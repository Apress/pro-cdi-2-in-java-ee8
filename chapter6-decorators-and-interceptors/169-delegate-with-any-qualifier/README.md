## Chapter 6 - Decorator with qualified delegate

This example shows how to create a decorator that uses a qualifier to limit which types it can be applied to.

## Class listing

| Page | Class                                                                                                                            | Description                                                                                               |
|------|----------------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------|
| N/A  | [GreetingInterface](src/main/java/org/omnifaces/procdi/decorators/greeting/qualified/any/GreetingInterface.java)                 | A common interface for classes generating greetings.                                                      |
| N/A  | [DutchGreetingBean](src/main/java/org/omnifaces/procdi/decorators/greeting/qualified/any/DutchGreetingBean.java)                 | A bean that implements the `GreetingInterface` and will generate Dutch language greetings.                |
| N/A  | [EnglishGreetingBean](src/main/java/org/omnifaces/procdi/decorators/greeting/qualified/any/EnglishGreetingBean.java)             | A bean that implements the `GreetingInterface` and will generate English language greetings.              |
| 168  | [Language](src/main/java/org/omnifaces/procdi/decorators/greeting/qualified/any/Language.java)                                   | A qualifier that can be used to select a bean based on the language.                                      |
| 169  | [GreetingDecoratorBean](src/main/java/org/omnifaces/procdi/decorators/greeting/qualified/any/GreetingDecoratorBean.java)         | A decorator that will apply to any implementation of  `GreetingInterface`, regardless of their qualifiers |
| N/A  | [QualifiedDelegateDemo](src/main/java/org/omnifaces/procdi/decorators/greeting/qualified/any/QualifiedDelegateDemo.java)         | Demo class that shows the `GreetingDecoratorBean` being applied.                                          |
| N/A  | [GreetingDecoratorBeanTest](src/test/java/org/omnifaces/procdi/decorators/greeting/qualified/any/GreetingDecoratorBeanTest.java) | Unit test for the `GreatingDecoratorBean`.                                                                |
