package by.bypet;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class LoginTest {

    @Test
    public void test1() {
        given()
                .body(LoginRequest.getBody(""))
        .when()
                .post(by.bypet.LoginRequest.LOGIN_URL)
        .then()
                .log().all()
                .statusCode(422)
                .body("errors.phone_stripped[0]", equalTo("The phone stripped field is required."));
    }
}
