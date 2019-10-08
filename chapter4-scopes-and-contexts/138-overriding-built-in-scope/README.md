# Overriding a built-in scope

This example shows how to override the session scope by providing a custom session scope context.

# Code listings

| Code                                                                                                           | Description                                    |
|----------------------------------------------------------------------------------------------------------------|------------------------------------------------|
| [CustomSessionScopeContext](src/main/java/org/omnifaces/procdi/scopes/override/CustomSessionScopeContext.java) | A custom session scope context implementation. |

## Additional code

| Code                                                                                                                             | Description                                                             |
|----------------------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------|
| [BeanInstance](src/main/java/org/omnifaces/procdi/scopes/override/BeanInstance.java)                                             | A bean instance helper-class for holding and destroying bean instances. |
| [CustomSessionScopeContextExtension](src/main/java/org/omnifaces/procdi/scopes/override/CustomSessionScopeContextExtension.java) | An extension to register the custom session scope context.              |
| [CustomSessionScopeContextTest](src/test/java/org/omnifaces/procdi/scopes/override/CustomSessionScopeContextTest.java)           | A test displaying the usage of the custom session scope context.        |
