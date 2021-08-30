package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class DeletePetStepDefinitions {
    private final static String BASE_PATH = "/api/v3/pet/150";
    private Response response;
    @Given("I send a delete request to delete the pet")
    public void I_delete_a_pet() throws IOException {
        response = given()
                .when()
                .delete(BASE_PATH)
                .then()
                .extract().response();
    }

    @Then("I verify pet deleted from pet store")
    public void I_verify_pet_deleted_from_store(){
        System.out.println("Response ::: "+ response.asString());
        System.out.println("Response code::: "+ response.statusCode());
        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals("Pet deleted", response.asString());

    }

}
