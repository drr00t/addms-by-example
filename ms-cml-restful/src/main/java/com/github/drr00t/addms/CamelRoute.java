package com.github.drr00t.addms;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.apache.camel.model.rest.RestParamType;

public class CamelRoute extends RouteBuilder {

    @Override
    public void configure() {
        // restConfiguration()
        //         // .component("servlet")
        //         // .port(8080)
        //         // .host("127.0.0.1")
        //         .apiContextPath("api-docs")
        //         // .apiContextIdPattern("#name#")
        //         .apiProperty("api.title", "Test REST API")
        //         .apiProperty("api.version", "v1")
        //         .apiProperty("cors", "true")
        //         .bindingMode(RestBindingMode.json);
        restConfiguration().component("netty-http").bindingMode(RestBindingMode.json)
            // and output using pretty print
            .dataFormatProperty("prettyPrint", "true")
            // setup context path and port number that netty will use
            .contextPath("/").port(8080)
            // add OpenApi api-doc out of the box
            .apiContextPath("/api-doc")
                .apiProperty("api.title", "User API").apiProperty("api.version", "1.2.3")
                // and enable CORS
                .apiProperty("cors", "true");

                        // this user REST service is json only
        rest("/user").description("User rest service")
        .consumes("application/json").produces("application/json")
        .get("/{id}").description("Find user by id").outType(User.class)
            .param().name("id").type(RestParamType.path).description("The id of the user to get").dataType("int").endParam()
            .to("bean:userService?method=getUser(${header.id})")
        .put().description("Updates or create a user").type(User.class)
            .param().name("body").type(RestParamType.body).description("The user to update or create").endParam()
            .to("bean:userService?method=updateUser")
        .get("/findAll").description("Find all users").outType(User[].class)
            .to("bean:userService?method=listUsers");

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