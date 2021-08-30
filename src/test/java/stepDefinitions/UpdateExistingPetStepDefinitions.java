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

public class UpdateExistingPetStepDefinitions {

    private RequestSpecification parentRequestSpec,requestSpec;
    ResponseSpecification parentResponseSpec;
    private Response response;
    String baseURI="http://localhost:8080";

    private final static String BASE_PATH = "/api/v3/pet";
    private final static String UPDATE_EXISTING_PET_REQ_BODY = "C:\\HomeChallengeAPITest\\src\\main\\java\\data\\updatepetwithformdata.json";

    @Given("I have request URL for updating a pet")
    public void i_have_request_url() throws IOException {
        parentRequestSpec = new RequestSpecBuilder()
                .setBaseUri(baseURI)
                .setContentType(ContentType.JSON)
                .setRelaxedHTTPSValidation()
                .setBasePath(BASE_PATH)
                .addHeader("Content-Type", "application/json")
                .setBody(new String(Files.readAllBytes(Paths.get(UPDATE_EXISTING_PET_REQ_BODY))))
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
