package by.tabletka;

import java.util.HashMap;
import java.util.Map;

public class LoginRequest {
    public static final String URL_LOGIN = "https://tabletka.by/ajax-request/login";

    public static Map<String, String> getHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        headers.put("Cookie", "PHPSESSID=sn3lduti1bcgr0j067kdbnvjem; _csrf=5f79393169d6d1dd663e5835b400145970558c8b1071cc61e563ae1cb44379b2a%3A2%3A%7Bi%3A0%3Bs%3A5%3A%22_csrf%22%3Bi%3A1%3Bs%3A32%3A%22SUKKXsEYZjIIRRpuZOj7r4JjZhayzYBm%22%3B%7D; _ga=GA1.1.1948258482.1730994936; regionId=0; _ga_S6LL4MRH46=GS1.1.1730997149.2.1.1730997908.0.0.0");
        headers.put("X-Requested-With", "XMLHttpRequest");
        return headers;
    }

    public static String getBody() {
        return "_csrf=u_iHJIMaAq-SBGLHCciXylZ35kN8NAM6suSWd1nfAdzorcxv22lH9shuK45bmue_DDiMdA4ASVDojPcOI4ZDsQ%3D%3D&email=fdsfdsfds%40mail.vf&password=%D0%B2%D0%BF%D0%B2%D0%B0%D0%BF%D0%B0%D0%B2%D0%BF&rememberMe=on";
    }
}
