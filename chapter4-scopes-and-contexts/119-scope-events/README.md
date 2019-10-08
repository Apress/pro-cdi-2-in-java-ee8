# Scope events

This example show how to listen for CDI scope lifecycle events. 

## Code listing

| Code                                                                                                   | Description                                                                                                |
| ------------------------------------------------------------------------------------------------------ | ---------------------------------------------------------------------------------------------------------- |
| [RequestScopeEvents](src/main/java/org/omnifaces/procdi/scopes/events/RequestScopeEvents.java)         | Application-scoped listener class that listens to lifecycle events for the request scope.                  |
| [RequestScopeEventsDemo](src/main/java/org/omnifaces/procdi/scopes/events/RequestScopeEventsDemo.java) | Demo class that starts and stops a request scope. This class can be run using the command "mvn exec:exec". |