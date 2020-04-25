package org.it.discovery.training.hibernate.generator;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

public class CounterGenerator implements IdentifierGenerator {
    private AtomicInteger counter = new AtomicInteger(0);

    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor,
                                 Object o) throws HibernateException {
        //TODO Add unit-tests for multi-threading use-cases
        return counter.incrementAndGet();
    }
}