package testCases;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class deletePet {

    @BeforeAll
    public static void setup() {
        baseURI = "http://localhost:8080";
    }

    private final static String BASE_PATH = "/api/v3/pet/150";

    //Delete a pet by passing its id
    @Test
    public void deleteRequest() {
        Response response = given()
                .when()
                .delete(BASE_PATH)
                .then()
                .extract().response();
        System.out.println("Response ::: "+ response.asString());
        System.out.println("Response code::: "+ response.statusCode());
        Assertions.assertEquals(200, response.statusCode());
    }
}
