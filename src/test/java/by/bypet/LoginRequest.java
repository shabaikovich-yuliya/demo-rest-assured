package by.bypet;

import java.util.HashMap;
import java.util.Map;

public class LoginRequest {
    public static final String LOGIN_URL = "https://bypet.by/auth/login";

    public static String getBody(String phoneStripped) {
        return "{\n" +
                "    \"phone_stripped\": \"" + phoneStripped +"\",\n" +
                "    \"phone\": \"+375 (29) 111-11-11\",\n" +
                "    \"password\": \"123456789\"\n" +
                "}";
    }


}
