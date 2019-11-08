package org.omnifaces.procdi.interceptors.producers;

import java.util.List;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InterceptionFactory;

import org.omnifaces.procdi.interceptors.producers.LogAccess.LogAccessLiteral;

public class Producers {
    @Produces
    @LogAccess
    public List<Number> produceInterceptedList(
      InterceptionFactory<List<Number>> factory) {
        List<Number> numbers = List.of(2, 3, 5, 7);

        factory.configure().add(new LogAccessLiteral());

        return factory.createInterceptedInstance(numbers);
    }
}
