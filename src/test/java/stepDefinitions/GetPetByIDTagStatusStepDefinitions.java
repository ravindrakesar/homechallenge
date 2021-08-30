package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.given;

public class GetPetByIDTagStatusStepDefinitions {
    private Response response;

    //GET Finds pets by id
    @Given("I send id to the request to get pet details")
    public void i_have_the_request_url() {
        response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/api/v3/pet/7")
                .then()
                .extract().response();
    }

    @Then("I verify response data")
    public void I_verify_response_data() {
        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals("Lion 1", response.jsonPath().getString("name"));
    }

    //GET Finds pets by tags
    @Given("I send tags to the request to get pet details")
    public void findPetByTags() {
        response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/api/v3/pet/findByTags?tags=kamal&tags=string")
                .then()
                .extract().response();
    }

    //GET Finds pets by status
    @Given("I send status to the request to get pet details")
    public void findPetByStatus() {
         response = given()
                .contentType(ContentType.JSON)
                .param("status", "pending")
                .when()
                .get("/api/v3/pet/findByStatus")
                .then()
                .extract().response();
    }

    @Then("I check response status code")
    public void check_response_status_code() {
        Assertions.assertEquals(200, response.statusCode());
    }

}
