
package com.github.drr00t.addms;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import static io.restassured.RestAssured.given;

/**
 * JVM mode tests.
 */
@QuarkusTest
public class RestJsonTest {

    @Test
    public void dashed() {

        /* Assert the initial fruits are there */
        given()
                .when().get("/api/dashed")
                .then()
                .statusCode(200);
        }

}
