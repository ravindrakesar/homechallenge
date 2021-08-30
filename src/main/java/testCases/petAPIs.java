package testCases;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class petAPIs {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost:8080";
    }

    //GET Find pet by id
    @Test
    public void findPetByID() {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/api/v3/pet/143")
                .then()
                .extract().response();

        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals("vimal", response.jsonPath().getString("name"));
    }

    //GET Finds pets by status
    @Test
    public void findPetByStatus() {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/api/v3/pet/findByStatus?status=pending")
                .then()
                .extract().response();

        Assertions.assertEquals(200, response.statusCode());
    }

    //GET Finds pets by tags
    @Test
    public void findPetByTags() {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/api/v3/pet/findByTags?tags=kamal&tags=string")
                .then()
                .extract().response();

        Assertions.assertEquals(200, response.statusCode());
    }
}
