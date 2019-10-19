## Chapter 6 - Decorator with qualified delegate

This example shows how to create a decorator that uses a qualifier to limit which types it can be applied to.

## Class listing

| Page | Class                                                                                                                        | Description                                                                                  |
|------|------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------|
| N/A  | [GreetingInterface](src/main/java/org/omnifaces/procdi/decorators/greeting/qualified/GreetingInterface.java)                 | A common interface for classes generating greetings.                                         |
| N/A  | [DutchGreetingBean](src/main/java/org/omnifaces/procdi/decorators/greeting/qualified/DutchGreetingBean.java)                 | A bean that implements the `GreetingInterface` and will generate Dutch language greetings.   |
| N/A  | [EnglishGreetingBean](src/main/java/org/omnifaces/procdi/decorators/greeting/qualified/EnglishGreetingBean.java)             | A bean that implements the `GreetingInterface` and will generate English language greetings. |
| 168  | [Language](src/main/java/org/omnifaces/procdi/decorators/greeting/qualified/Language.java)                                   | A qualifier that can be used to select a bean based on the language.                         |
| 168  | [GreetingDecoratorBean](src/main/java/org/omnifaces/procdi/decorators/greeting/qualified/GreetingDecoratorBean.java)         | A decorator that will apply to all English language implementations of `GreetingInterface`.  |
| N/A  | [QualifiedDelegateDemo](src/main/java/org/omnifaces/procdi/decorators/greeting/qualified/QualifiedDelegateDemo.java)         | Demo class that shows the `GreetingDecoratorBean` being applied.                             |
| N/A  | [GreetingDecoratorBeanTest](src/test/java/org/omnifaces/procdi/decorators/greeting/qualified/GreetingDecoratorBeanTest.java) | Unit test for the `GreatingDecoratorBean`.                                                   |
