
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
        private final Set<Film> films = Collections.synchronizedSet(new LinkedHashSet<>());

        public Routes() {

                /* Let's add some initial films */
                this.films.add(new Film("Império Contra-Ataca", "Parte da Trilogia Start Wars"));
                this.films.add(new Film("Matrix", "Just matrix"));
        }

        @Override
        public void configure() throws Exception {

                restConfiguration().bindingMode(RestBindingMode.json);
                rest("/films").get().consumes("application/json").to("direct:getFilms").post()
                                .type(Film.class).to("direct:addFilm");

                from("direct:getFilms").setBody().constant(films);

                from("direct:addFilm").process().body(Film.class, films::add).setBody()
                                .constant(films);
        }
}
