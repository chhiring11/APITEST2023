package apiTest;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ValidatePutRequest {

    public static String urlPutRequest ="https://fakerestapi.azurewebsites.net/api/v1/Users/110";

    public static String contentType ="application/json";


    public static Map payload = null;

    @Test
    public void verifyResponseCodeOfPutRequest(){

    payload = new HashMap();

    payload.put("id", "111");
    payload.put("userName", "Chhiring");
    payload.put("password", "Nepal");

        given().contentType(contentType).body(payload)
                .when()
                .put(urlPutRequest)
                .then()
                .statusCode(200);

    }

    @Test
    public static void verifyIDChangeInResponseOfPutRequest() {

        payload = new HashMap<>();

        payload.put("id", "111");
        payload.put("userName", "Chhiring");
        payload.put("password", "Nepal");

        given().contentType(contentType).body(payload)
                .when()
                .put(urlPutRequest)
                .then()
                .statusCode(200)
                .log()
                .body()
                .body("id", equalTo(111));

    }

    @Test
    public static void verifyUserNameChangeInResponseOfPutRequest() {

        payload = new HashMap<>();

        payload.put("id", "111");
        payload.put("userName", "Dolkar");
        payload.put("password", "Nepal");

        given().contentType(contentType).body(payload)
                .when()
                .put(urlPutRequest)
                .then()
                .statusCode(200)
                .log()
                .body()
                .body("userName", equalTo("Dolkar"));

    }

    @Test
    public static void verifyPasswordChangeInResponseOfPutRequest() {

        payload = new HashMap<>();

        payload.put("id", "111");
        payload.put("userName", "Chhiring");
        payload.put("password", "Hong Kong");

        given().contentType(contentType).body(payload)
                .when()
                .put(urlPutRequest)
                .then()
                .statusCode(200)
                .log()
                .body()
                .body("password", equalTo("Hong Kong"));

    }





}
