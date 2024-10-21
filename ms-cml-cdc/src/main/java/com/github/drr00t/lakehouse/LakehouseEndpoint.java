package com.github.drr00t.lakehouse;

import org.apache.camel.Consumer;
import org.apache.camel.Processor;
import org.apache.camel.Producer;
import org.apache.camel.support.DefaultEndpoint;

// https://github.com/apache/camel/blob/main/components/camel-debezium/camel-debezium-common/camel-debezium-common-component/src/main/java/org/apache/camel/component/debezium/DebeziumEndpoint.java#L67
public class LakehouseEndpoint<T extends LakehouseConfiguration> extends DefaultEndpoint {

    protected LakehouseEndpoint(String uri, LakehouseComponent<T> component) {
        super(uri, component);
    }

    protected LakehouseEndpoint() {}

    @Override
    public Producer createProducer() throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createProducer'");
    }

    @Override
    public Consumer createConsumer(Processor processor) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createConsumer'");
        // throw new UnsupportedOperationException(
        // "Cannot consume from a LakehouseEndpoint: " + getEndpointUri());
    }

}
