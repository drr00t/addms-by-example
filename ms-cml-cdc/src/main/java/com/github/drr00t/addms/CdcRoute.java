package com.github.drr00t.addms;

import java.util.Map;

import org.apache.camel.builder.RouteBuilder;

public class CdcRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("debezium-postgres:locahost?topicPrefix=teste&databasePassword=postgres")
                .log("BODY-> ${body}") // .choice().when(header("CamelDebeziumOperation").isEqualTo("c"))
                .convertBodyTo(Map.class).to("direct:logging");
        // .to("mongodb:mydb?database={{mongodb.database}}&collection={{mongodb.collection}}&operation=insert");

        from("direct:logging").log("${body}");
    }
}
