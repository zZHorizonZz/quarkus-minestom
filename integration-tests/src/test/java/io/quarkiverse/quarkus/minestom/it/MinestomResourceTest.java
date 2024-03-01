package io.quarkiverse.quarkus.minestom.it;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class MinestomResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
                .when().get("/minestom")
                .then()
                .statusCode(200)
                .body(is("Hello minestom"));
    }
}
