package org.omnifaces.procdi.scopes.events;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.BeforeDestroyed;
import javax.enterprise.context.Destroyed;
import javax.enterprise.context.Initialized;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;

@ApplicationScoped
public class RequestScopeEvents {

    public void onInitialization(
      @Observes @Initialized(RequestScoped.class) Object o) {
        System.out.println("Request scope initialized");
    }

    public void onBeforeDestruction(
      @Observes @BeforeDestroyed(RequestScoped.class) Object o) {
        System.out.println("Request scope about to be destroyed");
    }

    public void onDestroyed(
      @Observes @Destroyed(RequestScoped.class) Object o) {
        System.out.println("Request scope destroyed");
    }
}
