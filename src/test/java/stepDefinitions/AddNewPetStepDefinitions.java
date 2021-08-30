package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class AddNewPetStepDefinitions {

    private RequestSpecification parentRequestSpec,requestSpec;
    ResponseSpecification parentResponseSpec;
    private Response response;
    String baseURI="http://localhost:8080";

    private final static String BASE_PATH = "/api/v3/pet";
    String ADD_NEW_PET_REQ_BODY = "C:\\HomeChallengeAPITest\\homechallenge\\src\\main\\java\\data\\addnewpet.json";

    @Given("I have the request URL for pet store")
    public void requestURL() throws IOException {
        parentRequestSpec = new RequestSpecBuilder()
                .setBaseUri(baseURI)
                .setContentType(ContentType.JSON)
                .setRelaxedHTTPSValidation()
                .setBasePath(BASE_PATH)
                .addHeader("Content-Type", "application/json")
                .setBody(new String(Files.readAllBytes(Paths.get(ADD_NEW_PET_REQ_BODY))))
                .build();
        parentResponseSpec = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
    }

    @When("I add the new pet to the store")
    public void i_add_a_new_pet_to_the_store() throws IOException {
         requestSpec = given().spec(parentRequestSpec);
         response = requestSpec.when().post();
    }

    @Then("I verify that the pet is added to the store")
    public void pet_is_added_to_the_store(){
        System.out.println("Response ::: "+ response.asString());
        response.then().spec(parentResponseSpec).assertThat().statusCode(200);
    }
}
