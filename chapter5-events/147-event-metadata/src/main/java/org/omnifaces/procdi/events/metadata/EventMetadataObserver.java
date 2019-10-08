package org.omnifaces.procdi.events.metadata;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.EventMetadata;

@ApplicationScoped
public class EventMetadataObserver {

    public void observerWithMetadata(
      @Observes @ParameterizedQualifier(name = "") String event,
      EventMetadata eventMetadata) {
        ParameterizedQualifier qualifier =
          eventMetadata.getQualifiers()
            .stream()
            .filter(
              annotation -> annotation instanceof ParameterizedQualifier)
            .map(ParameterizedQualifier.class::cast)
            .findFirst()
            .orElseThrow();

        String name = qualifier.name();

        System.out.println(
          "Event " + event + " with name " + name + " observed.");
    }

    public void observe(@Observes @MyQualifier String event,
      EventMetadata eventMetadata) {
        Bean<?> bean = eventMetadata.getInjectionPoint().getBean();
        String scope = bean.getScope().getName();
        String beanClassName = bean.getBeanClass().getName();

        System.out.println(
          "Event " + event + " fired from bean " + beanClassName +
            " with scope " + scope);
    }
}
