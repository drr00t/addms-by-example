package com.github.drr00t;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;

/**
 * JVM mode tests.
 */
@QuarkusTest
public class RestJsonTest {

        @Test
        public void films() {
                /* Assert the initial films are there */
                given().when().get("/films").then().statusCode(200).body("$.size()", is(2), "name",
                                containsInAnyOrder("Império Contra-Ataca", "Matrix"), "description",
                                containsInAnyOrder("Parte da Trilogia Start Wars", "Just matrix"));

                /* Add a new fruit */
                given().body("{\"name\": \"Pear\", \"description\": \"Winter fruit\"}")
                                .header("Content-Type", "application/json").when().post("/films")
                                .then().statusCode(200).body("$.size()", is(3), "name",
                                                containsInAnyOrder("Império Contra-Ataca", "Matrix",
                                                                "Pear"),
                                                "description",
                                                containsInAnyOrder("Parte da Trilogia Start Wars",
                                                                "Just matrix", "Winter fruit"));
        }
}
