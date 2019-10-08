# Observer ordering

Demo demonstrating the observer ordering, based on the examples on 145 and 146 of the book.

This demo fires an event which is received by the various observers defined in this module. These observers also will receive any events that will be
fired by the CDI container.

## Code listing

| Code                                                                                               | Description                                                                                        |
|----------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------|
| [ApplicationObserver](src/main/java/org/omnifaces/procdi/events/ordering/ApplicationObserver.java) | An observer that demonstrates the ordering of observers using priorities defined for applications. |
| [LibraryObserver](src/main/java/org/omnifaces/procdi/events/ordering/LibraryObserver.java)         | An observer demonstrating the ordering of observers using the library before and after priorities. |


### Additional code

| Code                                                                                                 | Description                                                     |
|------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------|
| [ObserverOrderingDemo](src/main/java/org/omnifaces/procdi/events/ordering/ObserverOrderingDemo.java) | A demo of the order in which events are delivered to observers. |

