package com.jinnyjinnyjinjin.ecommerce.domain.config;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

import java.util.Objects;


public class CustomPhysicalNamingStrategy implements PhysicalNamingStrategy {

    @Override
    public Identifier toPhysicalCatalogName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        return convertToLowercase(convertToSnakeCase(name));
    }

    @Override
    public Identifier toPhysicalSchemaName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        return convertToLowercase(convertToSnakeCase(name));
    }

    @Override
    public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        return convertToSnakeCase(name);
    }

    @Override
    public Identifier toPhysicalSequenceName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        return convertToLowercase(convertToSnakeCase(name));
    }

    @Override
    public Identifier toPhysicalColumnName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        return convertToLowercase(convertToSnakeCase(name));
    }

    private Identifier convertToSnakeCase(Identifier originName) {
        final String regex = "([a-z])([A-Z])";
        final String replacement = "$1_$2";
        String converted = null;
        if (!Objects.isNull(originName)) {
            converted = originName.getText()
                    .replaceAll(regex, replacement);
        }
        return Identifier.toIdentifier(converted);
    }

    private Identifier convertToLowercase(Identifier name) {
        return !Objects.isNull(name) ? Identifier.toIdentifier(name.getText().toLowerCase()) : null;
    }
}
