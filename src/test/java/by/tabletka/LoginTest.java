package by.tabletka;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class LoginTest {

    @Test
    @DisplayName("Test unregistered user")
    public void test1() {
        String bodyRequest = "_csrf=u_iHJIMaAq-SBGLHCciXylZ35kN8NAM6suSWd1nfAdzorcxv22lH9shuK45bmue_DDiMdA4ASVDojPcOI4ZDsQ%3D%3D&email=fdsfdsfds%40mail.vf&password=%D0%B2%D0%BF%D0%B2%D0%B0%D0%BF%D0%B0%D0%B2%D0%BF&rememberMe=on";

        given()
                .headers(LoginRequest.getHeaders())
                .body(bodyRequest)
        .when()
                .post(LoginRequest.URL_LOGIN)
        .then()
                .log().all()
                .statusCode(200)
                .body("status", equalTo(-1))
                .body("log", equalTo("Не найден пользователь или неправильный пароль."));
    }

    @Test
    @DisplayName("Test without body")
    public void test2() {
        given()
                .headers(LoginRequest.getHeaders())
        .when()
                .post(LoginRequest.URL_LOGIN)
        .then()
                .log().all()
                .statusCode(400)
                .body(equalTo("Bad Request (#400): Unable to verify your data submission."));
    }

    @Test
    @DisplayName("Test without header X-Requested-With")
    public void test3() {
        given()
                .body(LoginRequest.getBody())
                .header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
                .header("Cookie", "PHPSESSID=sn3lduti1bcgr0j067kdbnvjem; _csrf=5f79393169d6d1dd663e5835b400145970558c8b1071cc61e563ae1cb44379b2a%3A2%3A%7Bi%3A0%3Bs%3A5%3A%22_csrf%22%3Bi%3A1%3Bs%3A32%3A%22SUKKXsEYZjIIRRpuZOj7r4JjZhayzYBm%22%3B%7D; _ga=GA1.1.1948258482.1730994936; regionId=0; _ga_S6LL4MRH46=GS1.1.1730997149.2.1.1730997908.0.0.0")
        .when()
                .post(LoginRequest.URL_LOGIN)
        .then()
                .log().all()
                .statusCode(200)
                .body("status", equalTo(-1));
    }

    @Test
    @DisplayName("Test without Email")
    public void test4() {
        String bodyRequest = "_csrf=u_iHJIMaAq-SBGLHCciXylZ35kN8NAM6suSWd1nfAdzorcxv22lH9shuK45bmue_DDiMdA4ASVDojPcOI4ZDsQ%3D%3D&password=%D0%B2%D0%BF%D0%B2%D0%B0%D0%BF%D0%B0%D0%B2%D0%BF&rememberMe=on";

        given()
                .body(bodyRequest)
                .headers(LoginRequest.getHeaders())
        .when()
                .post(LoginRequest.URL_LOGIN)
        .then()
                .log().all()
                .statusCode(200)
                .body("status", equalTo(-1))
                .body("log", equalTo("Не найден пользователь или неправильный пароль."));
    }

    @Test
    @DisplayName("Test without Email and Password")
    public void test5() {
        String bodyRequest = "_csrf=u_iHJIMaAq-SBGLHCciXylZ35kN8NAM6suSWd1nfAdzorcxv22lH9shuK45bmue_DDiMdA4ASVDojPcOI4ZDsQ%3D%3D&rememberMe=on";

        given()
                .body(bodyRequest)
                .headers(LoginRequest.getHeaders())
        .when()
                .post(LoginRequest.URL_LOGIN)
        .then()
                .log().all()
                .statusCode(200)
                .body("status", equalTo(-1))
                .body("log", equalTo("Не найден пользователь или неправильный пароль."));

    }

}
