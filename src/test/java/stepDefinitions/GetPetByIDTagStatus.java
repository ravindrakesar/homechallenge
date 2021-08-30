package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import testCases.petAPIs;

import static io.restassured.RestAssured.given;

public class GetPetByIDTagStatus {

    //GET Finds pets by id
    @Given("I verify the pet by sending id")
    public void i_have_the_request_url() {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/api/v3/pet/143")
                .then()
                .extract().response();
        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals("vimal", response.jsonPath().getString("name"));
    }

    //GET Finds pets by tags
    @Given("I verify the pet by sending tags")
        public void findPetByTags() {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/api/v3/pet/findByTags?tags=kamal&tags=string")
                .then()
                .extract().response();

        Assertions.assertEquals(200, response.statusCode());
    }

    //GET Finds pets by status
    @Given("I verify the pet by sending status")
    public void findPetByStatus() {
        Response response = given()
                .contentType(ContentType.JSON)
                .param("status","pending")
                .when()
                .get("/api/v3/pet/findByStatus")
                .then()
                .extract().response();

        Assertions.assertEquals(200, response.statusCode());
    }

}
