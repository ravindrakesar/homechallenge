package testCases;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class addnewPet {

    @BeforeAll
    public static void setup() {
        baseURI = "http://localhost:8080";
    }

    private final static String BASE_PATH = "/api/v3/pet";
    private final static String ADD_NEW_PET_REQ_BODY = "C:\\HomeChallengeAPITest\\src\\main\\java\\library\\addnewpet.json";

    RequestSpecification parentRequestSpec = new RequestSpecBuilder().setBaseUri(baseURI).setContentType(ContentType.JSON).setRelaxedHTTPSValidation().setBasePath(BASE_PATH).addHeader("Content-Type","application/json").build();
    ResponseSpecification parentResponseSpec = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();

    //POST Add new pet to the store
    @Test
    public void addnewpetTotheStore() throws IOException {
        RequestSpecification requestSpec =  given().spec(parentRequestSpec)
                .body(new String(Files.readAllBytes(Paths.get(ADD_NEW_PET_REQ_BODY))));
        Response response = requestSpec.when().post();

        System.out.println("Response ::: "+ response.asString());

        response.then().spec(parentResponseSpec).assertThat().statusCode(200);
    }
}
