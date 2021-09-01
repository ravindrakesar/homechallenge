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
import utilities.Utils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class AddNewPetStepDefinitions extends Utils {

    private RequestSpecification parentRequestSpec,requestSpec;
    ResponseSpecification parentResponseSpec;
    private Response response;

    private final static String BASE_PATH = "/api/v3/pet";

    @Given("I define the endpoint input data from {string}")
    public void requestURL(String fileName) throws IOException, URISyntaxException {
        parentRequestSpec = new RequestSpecBuilder()
                .setBaseUri(Utils.getGlobalValue("baseUri"))
                .setContentType(ContentType.JSON)
                .setRelaxedHTTPSValidation()
                .setBasePath(BASE_PATH)
                .addHeader("Content-Type", "application/json")
                .setBody(new String(Files.readAllBytes(Paths.get(REGISTER_INPUTDATA_FILE_FOLDER+fileName))))
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
        System.out.println(response.getBody().asString());
    }
}
