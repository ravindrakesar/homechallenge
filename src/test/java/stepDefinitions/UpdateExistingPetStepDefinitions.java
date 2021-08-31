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

public class UpdateExistingPetStepDefinitions extends Utils {

    private RequestSpecification parentRequestSpec,requestSpec;
    ResponseSpecification parentResponseSpec;
    private Response response;

    private final static String BASE_PATH = "/api/v3/pet";

    @Given("I set the endpoint input data from {string}")
    public void i_have_request_url(String fileName) throws IOException, URISyntaxException {
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

    @When("I update the existing pet store")
            public void i_update_existing_pet_store() {
        requestSpec = given().spec(parentRequestSpec);
        response = requestSpec.when().put();
    }

    @Then("I verify response data to check the update")
    public void i_verify_response_data(){
        System.out.println("Response ::: "+ response.asString());
        response.then().spec(parentResponseSpec).assertThat().statusCode(200);
    }


}
