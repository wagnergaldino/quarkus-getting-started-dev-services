package br.net.galdino;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class GreetingResourceTest {

    @Test
    void testHelloEndpoint() {
        given()
          .pathParam("name", "wagal")
          .when().get("/hello/{name}")
          .then()
             .statusCode(200)
             .body(is("Hello wagal from Quarkus REST"));
    }

    @Test
    void testNamesEndpoint() {
        given()
          .when().get("/hello/names")
          .then()
             .statusCode(200)
             .body(is("I've said hello to Alice, Bob"));
    }

}