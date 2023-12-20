package apiTest;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ValidateGetRequest {

    public String urlGetRequest1 = "https://fakerestapi.azurewebsites.net/api/v1/Users/5";

    public String urlGetRequest2 = "https://fakerestapi.azurewebsites.net/api/v1/Users/100";

    @Test
    public void verifyResponseCodeOfGivenGetRequest(){

        given()
                .when()
                .get(urlGetRequest1)
                .then()
                .statusCode(200);

    }

    @Test
    public void verifyIDValueInResponseOfGivenGetRequest(){
        given()
                .when()
                .get(urlGetRequest1)
                .then()
                .statusCode(200)
                .log()
                .body()
                .body("id", equalTo(5));
    }

    @Test
    public void verifyUserNameValueInResponseOfGivenGetRequest(){
        given()
                .when()
                .get(urlGetRequest1)
                .then()
                .statusCode(200)
                .log()
                .body()
                .body("userName", equalTo("User 5"));
    }

    @Test
    public void verifyResponseCodeOfInvalidGetRequest(){

        given()
                .when()
                .get(urlGetRequest2)
                .then()
                .statusCode(404);

    }


}




