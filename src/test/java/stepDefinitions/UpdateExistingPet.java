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

public class UpdateExistingPet {

    private final static String BASE_PATH = "/api/v3/pet";
    private final static String UPDATE_EXISTING_PET_REQ_BODY = "C:\\HomeChallengeAPITest\\src\\main\\java\\library\\updateexistingpet.json";

    RequestSpecification parentRequestSpec = new RequestSpecBuilder().setBaseUri(baseURI).setContentType(ContentType.JSON).setRelaxedHTTPSValidation().setBasePath(BASE_PATH).addHeader("Content-Type","application/json").build();
    ResponseSpecification parentResponseSpec = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();


    @Given("I update the pet by id")
    public void i_have_request_url() throws IOException {
        RequestSpecification requestSpec =  given().spec(parentRequestSpec)
                .body(new String(Files.readAllBytes(Paths.get(UPDATE_EXISTING_PET_REQ_BODY))));
        Response response = requestSpec.when().put();

        System.out.println("Response ::: "+ response.asString());

        response.then().spec(parentResponseSpec).assertThat().statusCode(200);
    }


}
