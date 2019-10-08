# Custom scope

This example show how to listen for CDI scope lifecycle events. 

## Code listing

| Code                                                                                                | Description                                                                              |
|-----------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------|
| [BeanInstance](src/main/java/org/omnifaces/procdi/scopes/customscope/BeanInstance.java)             | Bean instance class that is used as a helper to create, hold and destroy bean instances. |
| [CustomScope](src/main/java/org/omnifaces/procdi/scopes/customscope/CustomScope.java)               | Annotation used to apply the custom scope to a bean.                                     |
| [CustomScopeContext](src/main/java/org/omnifaces/procdi/scopes/customscope/CustomScopeContext.java) | Context implementation for the custom scope.                                             |

### Additional code

| Class                                                                                                   | Description                                                                                      |
|---------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------|
| [CustomScopeBean](src/main/java/org/omnifaces/procdi/scopes/customscope/CustomScopedBean.java)          | Example of a bean using the custom scope.                                                        |
| [CustomScopeDemo](src/main/java/org/omnifaces/procdi/scopes/customscope/CustomScopeDemo.java)           | Demo of using the custom scope, loosely based on the example on page 135.                        |
| [CustomScopeExtension](src/main/java/org/omnifaces/procdi/scopes/customscope/CustomScopeExtension.java) | Extension that registers the annotation and context for the custom scope with the CDI container. |
| [CustomScopeTest](src/test/java/org/omnifaces/procdi/scopes/customscope/CustomScopeTest.java)           | Fairly basic unit tests displaying some of the behaviour of the custom scope.                    |
