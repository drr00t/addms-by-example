package org.apache.camel.component.lakehouse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.HashMap;
import java.util.Map;
import org.apache.camel.component.debezium.DebeziumComponent;
import org.apache.camel.component.debezium.DebeziumEndpoint;
import org.apache.camel.component.debezium.DebeziumPostgresComponent;
import org.apache.camel.component.debezium.configuration.PostgresConnectorEmbeddedDebeziumConfiguration;
import org.apache.camel.impl.DefaultCamelContext;
import org.junit.jupiter.api.Test;
import com.github.drr00t.lakehouse.DeltaLakehouseComponent;
import com.github.drr00t.lakehouse.LakehouseComponent;
import com.github.drr00t.lakehouse.LakehouseEndpoint;

public class LakehouseComponentTest {
    @Test
    void testIfConnectorEndpointCreatedWithConfig() throws Exception {
        final Map<String, Object> params = new HashMap<>();
        params.put("offsetStorageFileName", "/offset_test_file");
        params.put("databaseHostname", "localhost");
        params.put("databaseUser", "dbz");
        params.put("databasePassword", "pwd");
        params.put("topicPrefix", "test");
        params.put("databaseServerId", 1234);
        params.put("schemaHistoryInternalFileFilename", "/db_history_file_test");

        final String remaining = "test_name";
        final String uri = "debezium?name=test_name&offsetStorageFileName=/test&"
                + "databaseHostname=localhost&databaseServerId=1234&databaseUser=dbz&databasePassword=pwd&"
                + "topicPrefix=test&schemaHistoryInternalFileFilename=/test";
        try (final LakehouseComponent debeziumComponent =
                new DeltaLakehouseComponent(new DefaultCamelContext())) {
            debeziumComponent.start();
            final LakehouseEndpoint debeziumEndpoint =
                    debeziumComponent.createEndpoint(uri, remaining, params);

            assertNotNull(debeziumEndpoint);

            // test for config
            final PostgresConnectorEmbeddedDebeziumConfiguration configuration =
                    (PostgresConnectorEmbeddedDebeziumConfiguration) debeziumEndpoint
                            .getConfiguration();
            assertEquals("test_name", configuration.getName());
            assertEquals("/offset_test_file", configuration.getOffsetStorageFileName());
            assertEquals("localhost", configuration.getDatabaseHostname());
            assertEquals("dbz", configuration.getDatabaseUser());
            assertEquals("pwd", configuration.getDatabasePassword());
            assertEquals("test", configuration.getTopicPrefix());
            assertEquals("/db_history_file_test",
                    configuration.getSchemaHistoryInternalFileFilename());

        }
    }
}
