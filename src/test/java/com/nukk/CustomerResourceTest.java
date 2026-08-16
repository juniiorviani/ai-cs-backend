package com.nukk;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;

@QuarkusTest
class CustomerResourceTest {

    @Test
    void listsTheWholeCustomerBase() {
        given()
          .when().get("/customers")
          .then()
             .statusCode(200)
             .body("$", hasSize(10))
             .body("id", everyItem(notNullValue()))
             .body("company", everyItem(notNullValue()));
    }

    @Test
    void allowsCorsFromAnyOrigin() {
        given()
          .header("Origin", "https://any-frontend.example.com")
          .when().get("/customers")
          .then()
             .statusCode(200)
             .header("access-control-allow-origin", is("https://any-frontend.example.com"));
    }

    @Test
    void returnsCustomerDetails() {
        given()
          .when().get("/customers/northwind-logistics")
          .then()
             .statusCode(200)
             .body("company", is("Northwind Logistics"))
             .body("healthScore", is(88))
             .body("tickets", hasSize(3))
             .body("lastLogin", notNullValue());
    }

    @Test
    void hasAtLeastThreeCustomersAtChurnRisk() {
        given()
          .when().get("/customers")
          .then()
             .statusCode(200)
             .body("findAll { it.healthScore < 50 }", hasSize(3));
    }

    @Test
    void churnRiskCustomerHasCollapsingUsage() {
        given()
          .when().get("/customers/pixelforge-studio")
          .then()
             .statusCode(200)
             .body("healthScore", is(28))
             .body("usage30d", is(310));
    }

    @Test
    void returns404ForUnknownCustomer() {
        given()
          .when().get("/customers/unknown-co")
          .then()
             .statusCode(404)
             .body("error", is("customer_not_found"));
    }

    @Test
    void analyzeReturns404ForUnknownCustomer() {
        given()
          .when().post("/customers/unknown-co/analyze")
          .then()
             .statusCode(404)
             .body("error", is("customer_not_found"));
    }
}
