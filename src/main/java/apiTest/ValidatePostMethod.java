package apiTest;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ValidatePostMethod {

    public static String urlPostRequest = "https://fakerestapi.azurewebsites.net/api/v1/Users";


    public static String contentType = "application/json";

    public static Map payload = null;

    @Test
    public static void validateResponseCodeInPostMethod() {
        payload = new HashMap();
        payload.put("id", "1");
        payload.put("userName", "Chhiring");
        payload.put("password", "Nepal");
        given().contentType(contentType).body(payload)
                .when()
                .post(urlPostRequest)
                .then()
                .statusCode(200);
    }

    @Test
    public static void validateIDValueInResponseOfPostMethod() {
        payload = new HashMap();
        payload.put("id", "101");
        payload.put("userName", "Chhiring");
        payload.put("password", "Nepal");
        given().contentType(contentType).body(payload)
                .when()
                .post(urlPostRequest)
                .then()
                .statusCode(200)
                .log()
                .body()
                .body("id", equalTo(101));

    }

    @Test
    public static void validateUserNameValueInResponseOfPostMethod() {
        payload = new HashMap();
        payload.put("id", "101");
        payload.put("userName", "Dolkar");
        payload.put("password", "Nepal");
        given().contentType(contentType).body(payload)
                .when()
                .post(urlPostRequest)
                .then()
                .statusCode(200)
                .log()
                .body()
                .body("userName", equalTo("Dolkar"));

    }
}

