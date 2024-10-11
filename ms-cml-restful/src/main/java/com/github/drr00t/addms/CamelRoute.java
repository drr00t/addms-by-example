package com.github.drr00t.addms;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;

public class CamelRoute extends RouteBuilder {

    @Override
    public void configure() {
        restConfiguration()
                // .component("servlet")
                // .port(8080)
                // .host("127.0.0.1")
                .apiContextPath("api-docs")
                // .apiContextIdPattern("#name#")
                .apiProperty("api.title", "Test REST API")
                .apiProperty("api.version", "v1")
                .apiProperty("cors", "true")
                .bindingMode(RestBindingMode.json);

        rest().path("api")
            // Dash '-' is not allowed by default
            .get("/dashed/").to("direct:greet");

            // // The non-dashed path parameter works by default
            // .get("/undashed/param/{myParam}")
            // .to("direct:greet");

            from("direct:greet")
                .setBody(constant("Hello World"));
    }
}