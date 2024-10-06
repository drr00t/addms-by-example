
package com.github.drr00t;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;

/**
 * Camel route definitions.
 */
public class Routes extends RouteBuilder {
        // private final Films films = new Films(); // Collections.synchronizedSet(new
        // // LinkedHashSet<>());

        // public Routes() {

        // /* Let's add some initial films */
        // this.films.add(new Film("Império Contra-Ataca", "Parte da Trilogia Start Wars"));
        // this.films.add(new Film("Matrix", "Just matrix"));
        // }

        @Override
        public void configure() throws Exception {

                restConfiguration().bindingMode(RestBindingMode.json);
                // .bindingPackageScan("com.github.drr00t.model");
                rest().openApi().specification("openapi.json").missingOperation("ignore");

                // from("direct:getFilms").setBody().constant(films);

                // from("direct:addFilm").process().body(Film.class, films::add).setBody()
                // .constant(films);
        }
}
