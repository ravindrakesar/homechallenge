package stepDefinitions;

import io.cucumber.java.en.Given;
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

public class AddNewPet {

    private final static String BASE_PATH = "/api/v3/pet";
    private final static String ADD_NEW_PET_REQ_BODY = "C:\\HomeChallengeAPITest\\src\\main\\java\\library\\addnewpet.json";

    RequestSpecification parentRequestSpec = new RequestSpecBuilder().setBaseUri(baseURI).setContentType(ContentType.JSON).setRelaxedHTTPSValidation().setBasePath(BASE_PATH).addHeader("Content-Type","application/json").build();
    ResponseSpecification parentResponseSpec = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();

    @Given("I add a new pet to the store")
    public void i_add_a_new_pet_to_the_store() throws IOException {
        RequestSpecification requestSpec =  given().spec(parentRequestSpec)
                .body(new String(Files.readAllBytes(Paths.get(ADD_NEW_PET_REQ_BODY))));
        Response response = requestSpec.when().post();

        System.out.println("Response ::: "+ response.asString());

        response.then().spec(parentResponseSpec).assertThat().statusCode(200);

    }
}
