package org.it.discovery.training.hibernate.naming;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

public class PrefixUpperCaseUnderscoreNamingStrategy extends PhysicalNamingStrategyStandardImpl {
    @Override
    public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment context) {
        return Identifier.toIdentifier(name.getText().toUpperCase(), name.isQuoted());
    }

    @Override
    public Identifier toPhysicalColumnName(Identifier name, JdbcEnvironment context) {
        return super.toPhysicalColumnName(name, context);
    }

    private String convertText(String text) {
        //todo add _ before big letters add unit tests
        return "ERV_" + text.toUpperCase();
    }

}
