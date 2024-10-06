package com.github.drr00t.addms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;

import com.github.drr00t.addms.model.Film;

/**
 * Camel route definitions.
 */
public class Routes extends RouteBuilder {
        private final Set<Film> films = Collections.synchronizedSet(new LinkedHashSet<>());

        public Routes() {

                /* Let's add some initial films */
                this.films.add(new Film().name("Império Contra-Ataca")
                                .description("Parte da Trilogia Start Wars"));
                this.films.add(new Film().name("Matrix").description("Just matrix"));
        }

        @Override
        public void configure() throws Exception {

                restConfiguration().bindingMode(RestBindingMode.json)
                                .bindingPackageScan("com.github.drr00t.addms.model");
                rest().openApi().specification("openapi.json").missingOperation("ignore");

                from("direct:getFilmById").setBody()
                                .constant(new Film().name("Império Contra-Ataca")
                                                .description("Parte da Trilogia Start Wars"));

                from("direct:getFilms").setBody().constant(films);

                from("direct:addFilm").process().body(Film.class, films::add).setBody()
                                .constant(films);
        }
}
