package com.github.drr00t.lakehouse;

import java.util.Map;
import org.apache.camel.CamelContext;
import org.apache.camel.component.debezium.DebeziumEndpoint;
import org.apache.camel.component.debezium.configuration.ConfigurationValidation;
import org.apache.camel.support.DefaultComponent;
import org.apache.camel.support.ObjectHelper;

public class LakehouseComponent<C extends LakehouseConfiguration> extends DefaultComponent {
    protected LakehouseComponent() {}

    protected LakehouseComponent(CamelContext context) {
        super(context);
    }

    @Override
    protected LakehouseEndpoint<C> createEndpoint(String uri, String remaining,
            Map<String, Object> parameters) throws Exception {

        // use a copy on the endpoint
        final C configuration = (C) getConfiguration().copy();

        if (ObjectHelper.isEmpty(remaining) && ObjectHelper.isEmpty(configuration.getName())) {
            throw new IllegalArgumentException(String.format(
                    "Connector name must be configured on endpoint using syntax debezium-%s:name",
                    configuration.getConnectorDatabaseType()));
        }

        // if we have name in path, we override the name in the configuration
        if (!ObjectHelper.isEmpty(remaining)) {
            configuration.setName(remaining);
        }

        LakehouseComponent<C> endpoint = initializeDebeziumEndpoint(uri, configuration);
        setProperties(endpoint, parameters);

        // extract the additional properties map
        if (PropertiesHelper.hasProperties(parameters, "additionalProperties.")) {
            final Map<String, Object> additionalProperties =
                    endpoint.getConfiguration().getAdditionalProperties();

            // add and overwrite additional properties from endpoint to pre-configured properties
            additionalProperties.putAll(
                    PropertiesHelper.extractProperties(parameters, "additionalProperties."));
        }

        // validate configurations
        final ConfigurationValidation configurationValidation =
                configuration.validateConfiguration();

        if (!configurationValidation.isValid()) {
            throw new IllegalArgumentException(configurationValidation.getReason());
        }

        return endpoint;
    }
}
